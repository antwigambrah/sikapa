<template>
    <div>

        <div class="row card-row">
            <div class="col-auto mr-auto">
                 <b-form-input v-model="filter" placeholder="Type to Search"></b-form-input>
            </div>
            <div class="col-auto">
                <button @click="modalShow = true" class="btn btn-success btn-sm">Add Branch</button>
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
                                variant="success"
                                size="sm"
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
                :current-page="currentPage"
                :per-page="perPage"

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
                    this.branches=res.data;
                    this.branches.map((branch)=>{
                        return {
                            "id":branch['id'],
                            "area":branch['area'],
                            "region":branch['region']
                        }
                    })
                });
                console.log(this.branches)
            this.totalRows = this.items.length
        },

        data() {
            return {
                modalShow: false,
                area:'',
                region:'',
                branches:[],
                items: [],
                totalRows: 1,
                currentPage: 1,
                perPage: 5,
                pageOptions: [5, 10, 15],
                sortBy: null,
                sortDesc: false,
                sortDirection: 'asc',
                filter: null,
                infoModal: {
                    id: 'info-modal',
                    title: '',
                    content: ''
                }
            }
        },
        methods:{
            createBranch(){
                axios.post("/branches",{
                    "area":this.area,
                    "region":this.region
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
        }

    }
</script>

<style scoped>

</style>