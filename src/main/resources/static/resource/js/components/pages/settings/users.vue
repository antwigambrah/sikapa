<template>
    <div>

        <div class="row card-row">
            <div class="col-auto mr-auto">
                 <b-form-input v-model="filter" placeholder="Type to Search"></b-form-input>
            </div>
            <div class="col-auto">
                <button @click="modalShow = true" class="btn btn-primary btn-block">Add User</button>
                <b-modal  v-model="modalShow" title="Add User" :hide-header-close=true >
                    <form>
                         <div class="form-group">
                            <input v-model="user.firstname" type="text" class="form-control" id="firstname"  placeholder="Firstname">
                        </div>
                        <div class="form-group">
                            <input v-model="user.middlename" type="text" class="form-control" id="middlename"  placeholder="Middlename">
                        </div>
                        <div class="form-group">
                            <input v-model="user.surname" type="text" class="form-control" id="surname"  placeholder="Surname">
                        </div>
                        <div class="form-group">
                                  <b-form-select v-model="user.roles" :options="roles"></b-form-select>
                        </div>
                        <div class="form-group">
                             <b-form-select v-model="user.branch.id" :options="branchData"></b-form-select>
                        </div>
                    </form>
                    <div slot="modal-footer" class="w-100">
                        <b-button
                                variant="primary"
                                size="block"
                                class="float-right"
                                @click="createUser()">
                            submit
                        </b-button>
                    </div>
                </b-modal>
                <b-modal v-model="userUpdateModal" title="Edit User" :hide-header-close=true>
                    <div class="form-group">
                        <b-form-select v-model="role" :options="roles"></b-form-select>
                    </div>
                    <div class="form-group">
                        <b-form-select v-model="branch" :options="branchData"></b-form-select>
                    </div>
                    <div slot="modal-footer" class="w-100">
                        <b-button
                                variant="primary"
                                size="block"
                                class="float-right"
                                @click="updateUser()">
                            submit
                        </b-button>
                    </div>

                </b-modal>
            </div>
        </div>
        <div class="card shadow-sm">
            <div class="card-body  table-card-body">        <!-- Main table element -->
        <b-table  responsive
                show-empty
                stacked="md"
                :fields="fields"
                :items="users"
                :current-page="currentPage"
                :per-page="perPage"
                :filter="filter"
                @filtered="onFiltered"
        >

            <template slot="actions" slot-scope="row">
                <button class="btn btn-sm btn-danger" @click="editUser(row.item.id)"><i class="lni-pencil"></i></button>
            </template>


        </b-table>
            </div>
        </div>
             <b-row>
            <b-col md="6" class="my-1">
                <b-pagination
                        v-model="currentPage"
                        :total-rows="totalRows"
                        :per-page="perPage"
                        class="my-0"
                ></b-pagination>
            </b-col>
        </b-row>

    </div>
</template>

<script type="text/javascript">
    import  {getResource,createResource,updateResource} from "../../../utils/resource";

    export default {
      async  mounted(){
            this.getUsers();
            this.getBranches();

        },
        computed: {

        },
        data() {
            return {
                modalShow: false,
                userUpdateModal:false,
                user:{
                    firstname:"",
                    middlename:"",
                    surname:"",
                    status:1,
                    role:null,
                    branch:{
                        id:null
                    }

                },
                role:null,
                branch:null,
                users:[],
                branchData:[
                    { value: null, text: 'Branch' },
                ],
                roles:[
                    { value: null, text: 'ROLE' },
                    { value: "ADMIN", text:'ADMIN'},
                    {value:"OFFICER",text:'OFFICER'},
                    {value:"RECOMMENDER",text:'RECOMMENDER'},
                    {value:"APPROVER",text:'APPROVER'}

                ],
                fields: ["id",'username', 'role', 'branch','actions'],
                totalRows: 1,
                currentPage: 1,
                perPage: 5,
                pageOptions: [5, 10, 15],
                sortBy: null,
                sortDesc: false,
                sortDirection: 'asc',
                filter: null,
                userid:null,
            }
        },
        methods:{
          async  createUser(){
              console.log(this.user)
                const[ex,res]= await  createResource("users",this.user);
                if (ex){
                    console.log(ex)
                } else {
                    this.modalShow=false;
                }

            },
            async getUsers(){
                const[ex,res1]= await getResource("users");
                if (ex){
                    console.log(ex);

                }else {

                   this.users= res1.data.map((user) => {
                        return{
                            id:user.id,
                            username: user.username,
                            role: user.roles,
                            branch: user['branch'] ? user['branch']['area'] : ''
                        }
                    });

                }
                },
            async getBranches(){
                const[ex,res]= await getResource("branches");
                    if (ex){
                        console.log(ex)
                    } else {
                        res.data.map((branch)=>{
                            this.branchData.push( {
                                value: branch["id"],
                                text: branch["area"]
                            });
                        })
                    }


            },
            async editUser(userid){
                this.userUpdateModal=true;
                this.userid=userid;
            },
            async updateUser(){
                this.userUpdateModal=false;
                const[ex,res]= await  updateResource("users/"+this.userid,{
                    "branch":{
                      "id":this.branch,
                    },
                    "roles":this.role,
                });
                if(ex){
                console.log(ex)
                }else{
                    this.getUsers();
                }
            },
            onFiltered(filteredItems) {
                // Trigger pagination to update the number of buttons/pages due to filtering
                this.totalRows = filteredItems.length
                this.currentPage = 1
            }
        }

    }
</script>

<style scoped>

</style>