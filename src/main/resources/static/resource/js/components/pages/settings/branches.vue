<template>
    <div>

        <div class="row card-row">
            <div class="col-auto mr-auto">
                <b-form-input v-model="filter" placeholder="Type to Search"></b-form-input>
            </div>
            <div class="col-auto">
                <button @click="modalShow = true" class="btn btn-primary  btn-block">Add Branch</button>
                <b-modal title="Add Branch" v-model="modalShow">
                    <form>
                        <div class="form-group">
                            <select class="form-control" v-model="region">
                                <option disabled value="">Region</option>
                                <option>Ashanti</option>
                                <option>Central</option>
                                <option>Western</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <select class="form-control" v-model="area">
                                <option disabled value="">Area</option>
                                <option>santasi</option>
                                <option>suame</option>
                                <option>wasa-akropong</option>
                            </select>
                        </div>
                    </form>
                    <div slot="modal-footer" class="w-100">
                        <b-button
                                variant="primary"
                                size="block"
                                class="float-right"
                                @click="createBranch"
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
                        head-variant="primary"
                        show-empty
                        stacked="md"
                        :items="branches"
                        :fields:="fields"
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
    import {getResource,createResource,updateResource} from "../../../utils/resource";

    export default {
        async mounted(){
          this.getBranches();
        },

        data() {
            return {
                modalShow: false,
                area:'',
                region:'',
                branches:[],
                fields:["banch","area"],
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
            createBranch(){
                axios.post("/branches",{
                    "area":this.area,
                    "region":this.region
                }).then((res)=>{
                    this.getBranches();
                    this.modalShow=false;
                })

            },
            async getBranches(){
                const[ex,res]= await getResource("branches");
                if (ex){
                    console.log(ex);
                } else {
                  this.branches=  res.data.map((branch)=>{
                        return {
                            "id":branch["id"],
                            "area":branch['area'],
                            "region":branch['region']
                        }
                    })
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