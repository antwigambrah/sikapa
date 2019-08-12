<template>
    <div>

        <div class="row card-row">
            <div class="col-auto mr-auto">
                 <b-form-input v-model="filter" placeholder="Type to Search"></b-form-input>
            </div>
            <div class="col-auto">
                <button @click="modalShow = true" class="btn btn-success btn-sm">Add User</button>
                <b-modal  v-model="modalShow" title="Add User" :hide-header-close=true >
                    <form>
                         <div class="form-group">
                            <input v-model="user.firstname" type="text" class="form-control" id="firstname"  placeholder="Firstname">
                        </div>
                        <div class="form-group">
                            <input v-model="user.middlename" type="text" class="form-control" id="middlename"  placeholder="Middlename">
                        </div>
                        <div class="form-group">
                            <input v-model="user.lastname" type="text" class="form-control" id="lastname"  placeholder="Lastname">
                        </div>
                        <div class="form-group">
                                  <b-form-select v-model="role" :options="roles"></b-form-select>
                        </div>
                        <div class="form-group">
                             <b-form-select v-model="branch" :options="branchData"></b-form-select>
                        </div>
                    </form>
                    <div slot="modal-footer" class="w-100">
                        <b-button
                                variant="success"
                                size="sm"
                                class="float-right"
                                @click="createUser()"
                        >
                            submit
                        </b-button>
                    </div>
                </b-modal>
            </div>
        </div>
        <div class="card shadow-sm">
            <div class="card-body  table-card-body">        <!-- Main table element -->
        <b-table
                show-empty
                stacked="md"
                :items="users"
                :current-page="currentPage"
                :per-page="perPage"
                :filter="filter"
                @filtered="onFiltered"
        >
            <template slot="name" slot-scope="row">
                {{ row.value.first }} {{ row.value.last }}
            </template>

            <template slot="isActive" slot-scope="row">
                {{ row.value ? 'Yes :)' : 'No :(' }}
            </template>

            <template slot="actions" slot-scope="row">
                <b-button size="sm" @click="info(row.item, row.index, $event.target)" class="mr-1">
                    Info modal
                </b-button>
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
    export default {
        mounted(){
            axios.get("branches").then((res)=>{
                res.data.map((branch)=>{
                    this.branchData.push({
                        value:branch["id"],
                        text:branch["area"]
                    })
                })
            });


                axios.get("users").then((res)=>{
                    console.log(res.data);
                 res.data.map((user)=>{
                        this.users.push({
                            username:user.username,
                            role:user.roles,
                            branch:user['branch']?user['branch']['area']:''
                        })
                    });
                });
            this.totalRows = this.items.length
        },
        computed: {
            // sortOptions() {
            //     // Create an options list from our fields
            //     return this.fields
            //         .filter(f => f.sortable)
            //         .map(f => {
            //             return { text: f.label, value: f.key }

            //         })
            // }
        },
        data() {
            return {
                modalShow: false,
                user:{
                    firstname:"",
                    middlename:"",
                    lastname:"",
                },
                area:'',
                region:'',
                branch:null,
                users:[],
                branchData:[
                    { value: null, text: 'Branch' },
                ],
                role:null,
                roles:[
                    { value: null, text: 'ROLE' },
                    { value: "ADMIN", text:'ADMIN'},
                    {value:"OFFICER",text:'OFFICER'},
                    {value:"RECOMMENDER",text:'RECOMMENDER'},
                    {value:"APPROVER",text:'APPROVER'}

                ],
                items: [],
                totalRows: 1,
                currentPage: 1,
                perPage: 5,
                pageOptions: [5, 10, 15],
                sortBy: null,
                sortDesc: false,
                sortDirection: 'asc',
                filter: null,
            }
        },
        methods:{
            createUser(){
                axios.post("users",{
                    "firstname":this.user.firstname,
                    "middlename":this.user.lastname,
                    "lastname":this.user.lastname,
                    "username":this.user.firstname.charAt(0).toUpperCase().concat(this.user.lastname),
                    "role":this.role,
                    "branch":this.branch
                }).then((res)=>{
                    console.log(res)
                    this.modalShow=false;
                })

            },
            info(item, index, button) {
                this.infoModal.title = `Row index: ${index}`
                this.infoModal.content = JSON.stringify(item, null, 2)
                this.$root.$emit('bv::show::modal', this.infoModal.id, button)
            },
            resetInfoModal() {
                this.infoModal.title = ''
                this.infoModal.content = ''
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