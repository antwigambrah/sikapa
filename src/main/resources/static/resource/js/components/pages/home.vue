<template>
   <div>
       <div class="row">
           <div class="col-4">
               <div class="card mb-3 shadow-sm indicator-card" style="max-width: 540px;">
                   <div class="card-body">
                       <div class="row no-gutters">
                           <div class="col-md-4 center">
                               <h4 class="count">
                                   {{initiated}}
                               </h4>
                           </div>
                           <div class="col-md-8 center">
                               <h3 class="count-text">Initiated</h3>
                           </div>
                       </div>
                   </div>
               </div>
           </div>
           <div class="col-4">
               <div class="card mb-3 shadow-sm indicator-card" style="max-width: 540px;">
                   <div class="card-body">
                       <div class="row no-gutters">
                           <div class="col-md-4 center">
                               <h4 class="count">
                                   {{approved}}
                               </h4>
                           </div>
                           <div class="col-md-8 center">
                               <h3 class="count-text">Approved</h3>
                           </div>
                       </div>
                   </div>
               </div>
           </div>
           <div class="col-4">
               <div class="card mb-3 shadow-sm indicator-card" style="max-width: 540px;">
                   <div class="card-body">
                       <div class="row no-gutters">
                           <div class="col-md-4 center">
                               <h4 class="count">
                                   {{disbursed}}
                               </h4>
                           </div>
                           <div class="col-md-8 center">
                               <h3 class="count-text">Disbursed</h3>
                           </div>
                       </div>
                   </div>
               </div>
           </div>

       </div>
       <div class="row">
           <div class="col-auto mr-auto">
 <b-form-input v-model="filter" placeholder="Type to Search"></b-form-input>
           </div>
           <div class="col-auto  btn-toolbar ">
               <div class="dropdown">
                   <button class="btn btn-primary btn-block dropdown-toggle " type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                       Create
                   </button>
                   <div class="dropdown-menu" aria-labelledby="New Application">
                       <a class="dropdown-item" href="/loan/individual">Individual</a>
                       <a class="dropdown-item" href="/loan/business">SME/Business</a>
                   </div>
               </div>
           </div>
       </div>
       <div class="row">
           <div class="col">
               <div class="card shadow-sm">
                   <div class="card-body table-card-body">

                       <b-table  responsive
                                 show-empty
                                 stacked="md"
                                 :fields="fields"
                                 :items="loans"
                                 :current-page="currentPage"
                                 :per-page="perPage"
                                 :filter="filter"
                                 @filtered="onFiltered"
                       >

                           <template slot="actions" slot-scope="row">
                               <button class="btn btn-sm btn-outline-primary" @click="editUser(row.item.id)"><i class="lni-eye"></i></button>
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
       </div>
   </div>
</template>

<script>
    import {getResource} from "../../utils/resource";

    export default {
        mounted(){
            this.getLoans();
        },
        name: "home",
        components:{

        },
        data(){
            return {
                loans:[],
                fields:["No.","client_name","account_no","amount","initiate_date","status","branch","actions"],
                totalRows: 1,
                currentPage: 1,
                perPage: 5,
                pageOptions: [5, 10, 15],
                sortBy: null,
                sortDesc: false,
                sortDirection: 'asc',
                filter: null,
                initiated:0,
                approved:0,
                disbursed:0

            }
        },
        methods:{
            async getLoans(){
                const[ex,res]= await  getResource("loan");
                console.log(res);
                this.loans=res.data.map((data)=>{
                    if (data["status"]==="INITIATED"){
                        this.initiated++;
                    } else if(data["status"]==="APPROVED"){
                        this.approved++;
                    }else {
                        this.disbursed++;
                    }
                    return {
                        "No.":data["id"],
                        "client_name":data["clientName"],
                        "account_no":data["accountNumber"],
                        "amount":data["amount"],
                        "initiate_date":data["initiateDate"],
                        "status":data["status"],
                        "branch":data["user"]["branch"]["area"]
                    }
                })
            },
            onFiltered(filteredItems) {
                // Trigger pagination to update the number of buttons/pages due to filtering
                this.totalRows = filteredItems.length;
                this.currentPage = 1
            }

        }
    }
</script>

<style scoped lang="scss">
    .indicator-card{
        .card-body {
            padding:10px;
            margin-top:15px;
            .col-md-4{
                padding-left:10px;
            }
            .col-md-8{
                margin-top: 20px;
                .count-text{
                    font-size:30px;
                }
            }
        }
    }
.count {
    font-weight: bold;
    font-size: 60px;
}
</style>