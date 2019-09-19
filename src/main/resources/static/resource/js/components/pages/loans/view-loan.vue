<template>
    <div>

        <div class="form-row">
            <div class="col-3">

            </div>
            <div class="col-9">
             <div class="form-row">
                 <div class="col">
                     <h4 class="text-font">Client Name</h4>
                     <h6>{{loanDetails.clientName}}</h6>
                 </div>
                 <div class="col">
                     <h4 class="text-font">Account Number</h4>
                     <h6>{{loanDetails.accountNumber}}</h6>
                 </div>
                 <div class="col">
                     <h4 class="text-font">Amount</h4>
                     <h6>{{loanDetails.amount}}</h6>
                 </div>
             </div>
                <hr>
                <div class="form-row">
                 <div class="col">
                     <h4 class="text-font">Initiate Date</h4>
                     <h6>{{loanDetails.initiateDate}}</h6>
                 </div>
                 <div class="col">
                     <h4 class="text-font">Start Date</h4>
                     <h6>{{loanDetails.startDate}}</h6>
                 </div>
                 <div class="col">
                     <h4 class="text-font">End Date</h4>
                     <h6>{{loanDetails.endDate}}</h6>
                 </div>
             </div>
                <hr>
                <div class="form-row">
                 <div class="col">
                     <h4 class="text-font">Branch</h4>
                     <h6>{{loanDetails.user.branch.area}}</h6>
                 </div>
                 <div class="col">
                     <h4 class="text-font">Staff Name</h4>
                     <h6>{{loanDetails.user.firstname + " "+ loanDetails.user.middlename + " "+ loanDetails.user.surname}}</h6>
                 </div>
                 <div class="col">
                     <h4 class="text-font">Role</h4>
                     <h6>{{loanDetails.user.roles}}</h6>
                 </div>
             </div>
                <hr>
                <div class="form-row">
                 <div class="col">
                     <h4 class="text-font">Status</h4>
                     <h6>{{loanDetails.status}}</h6>
                 </div>
                 <div class="col">
                     <h4 class="text-font">Change Status</h4>
                     <b-form-select v-model="status" :options="options"></b-form-select>

                 </div>
                 <div class="col">
                     <h4 class="text-font">Documents</h4>
                     <a :href="documentLink">{{loanDetails.documents}}</a>
                 </div>
             </div>
            </div>
            </div>

        <hr>
        <div class="row">
            <div class="col-auto mr-auto">.col-auto .mr-auto</div>
            <div class="col-auto">
                <b-button
                        variant="primary"
                        size="block"
                        class="float-right" @click="updateLoan"
                >
                    Update
                </b-button>
            </div>
        </div>

    </div>
</template>

<script>


    import {findResource, updateResource} from "../../../utils/resource";
    import loan from "./loan";

    export default {
        name: "view-loan",
        props:["loan"],
        mounted() {
            this.getLoan();
        },
        data(){
            return {
                loanDetails:{

                },
                status: null,
                options: [
                    { value: null, text: 'CHOOSE STATUS' },
                    { value: 'INITIATED', text: 'INITIATED' },
                    { value: 'APPROVED', text: 'APPROVED' },
                    { value: 'DISBURSED', text: 'DISBURSED' }
                ]
            }
        },
        methods:{
           async  getLoan(){
                const [ex,res]= await  findResource("/loan/"+this.loan);
               if (ex){
                   console.log(ex)
               } else {
                   this.loanDetails=res.data;
               }
            }
            ,
            async   updateLoan(){
                const[ex,res]= await  updateResource("/loan/"+this.loan,{
                    "status":this.status
                });
                this.$emit("getLoans","")
            },

        },
        computed:{
            documentLink(){
                return "https://sikapa.s3.eu-central-1.amazonaws.com/"+this.loanDetails.documents;
            }
        }
    }
</script>

<style scoped lang="scss">
.text-font{
    font-size:20px;
}

</style>