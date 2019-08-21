<template>
    <div>

        <div class="row card-row">
            <div class="col-auto mr-auto">
                <b-form-input v-model="filter" placeholder="Type to Search"></b-form-input>
            </div>
            <div class="col-auto">
                <a  href="/clients?type=individual" class="btn btn-primary btn-block">create</a>
            </div>
        </div>
        <div class="card shadow-sm">
            <div class="card-body  table-card-body">        <!-- Main table element -->
                <b-table
                        show-empty
                        stacked="md"
                        :items="clients"
                        :current-page="currentPage"
                        :per-page="perPage"
                        :filter="filter"
                        @filtered="onFiltered"
                        :fields="fields"
                         >
             <template slot="actions" slot-scope="row">
                <button class="btn btn-sm btn-primary" @click="viewClient(row.item.id)">
                   <i class="lni-magnifier"></i>
                    </button>
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
    import {getResource,createResource,updateResource} from "../../../utils/resource";

    export default {
        async mounted(){
            this.getClients();
        },

        data() {
            return {
                modalShow: false,
                clients:[],
                area:'',
                region:'',
                branches:[],
                fields:["id","account name","branch","account number","actions"],
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
           async  getClients(){
                const[ex,res]= await getResource("/clients/individual");
                if (ex){
                    console.log(ex)
                } else {
                    this.clients=res.data.map((client)=>{
                        return {
                            "id":client["id"],
                            "account name":this.fullName(client["firstName"],client["middleName"],client["surname"]),
                            "branch":client["branch"]["area"],
                             "account number":client["individual"]["accountNumber"]
                        }
                    })

                }
            },
            onFiltered(filteredItems) {
                // Trigger pagination to update the number of buttons/pages due to filtering
                this.totalRows = filteredItems.length;
                this.currentPage = 1
            },
            fullName(firstname,middlename,lastname){
                       let first_name=firstname.toString().charAt(0).toUpperCase()+ firstname.toString().slice(1);
                          let middle_name=middlename.toString().charAt(0).toUpperCase()+ middlename.toString().slice(1);
                       let last_name=lastname.toString().charAt(0).toUpperCase()+lastname.slice(1)

                return first_name + " "+ middle_name + " " + last_name;
            }
        },
        computed:{

        }

    }
</script>

<style scoped>

</style>