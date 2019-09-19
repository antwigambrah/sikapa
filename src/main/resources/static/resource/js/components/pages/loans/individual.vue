<template>
    <div>
        <div class="row">
            <div class="col-md-10 offset-md-1">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-4">
                                <h4>Link Account</h4>
                            </div>
                            <div class="col-8 ">
                                <form>
                                    <div class="form-row">
                                        <div class="col">
                                            <label class="form-label">Client Name</label>
                                            <input type="text" class="form-control" placeholder="Account" v-model="loan.clientName">
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="col">
                                            <label class="form-label">Client Account No.</label>
                                            <input type="text" class="form-control" placeholder="Account" v-model="loan.accountNumber">
                                        </div>
                                        <div class="col">
                                            <label class="form-label">Client Phone N.</label>
                                            <input type="text" class="form-control" placeholder="Account" v-model="loan.clientPhoneNumber">
                                        </div>
                                    </div>

                                </form>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-4">
                                <h4>Loan Details</h4>
                            </div>
                            <div class="col-8 ">
                                <form>
                                    <div class="form-row">
                                        <div class="col-6">
                                            <label class="form-label">Amount</label>
                                            <input type="number" class="form-control" placeholder="Amount" v-model="loan.amount">
                                        </div>
                                        <div class="col-6">
                                            <label class="form-label">Loan Product</label>
                                            <b-form-select v-model="loan.product.id" :options="products"></b-form-select>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="col">
                                            <label class="form-label">Purpose</label>
                                            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" v-model="loan.purpose"></textarea>

                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="col-6">
                                            <label class="form-label">Start Date</label>
                                            <date-picker v-model="loan.startDate" :config="dateOptions"></date-picker>
                                        </div>
                                        <div class="col-6">
                                            <label class="form-label">End Date</label>
                                            <date-picker v-model="loan.endDate" :config="dateOptions"></date-picker>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="col-6">
                                            <label class="form-label">Source of Income</label>
                                            <b-form-select v-model="loan.sourceOfIncome" :options="sourceofIncome"></b-form-select>

                                        </div>
                                        <div class="col-6">
                                            <label class="form-label">Collateral</label>
                                            <b-form-select v-model="loan.collateral" :options="collateral"></b-form-select>
                                        </div>
                                    </div>

                                </form>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-4">
                                <h4>Fees</h4>
                            </div>
                            <div class="col-8">
                                <div class="form-row">
                                    <div class="col-6">
                                        <label class="form-label">Commitment Fee</label>
                                        <div class="input-group mb-3">
                                            <input type="text" class="form-control" v-model="loan.commitmentFee" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="basic-addon2">
                                            <div class="input-group-append">
                                                <span class="input-group-text">%</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <label class="form-label">Insurance Premium</label>
                                        <div class="input-group mb-3">
                                            <input type="text" class="form-control" v-model="loan.insurancePremium" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="basic-addon2">
                                            <div class="input-group-append">
                                                <span class="input-group-text">%</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr>
                        <guarantor @guarantor="addGuarantor"></guarantor>
                        <hr>
                        <div class="row">
                            <div class="col-4">
                                <h4>Comments</h4>
                            </div>
                            <div class="col-8">
                                <textarea class="form-control"  rows="3" v-model="loan.comments"></textarea>
                            </div>
                        </div>

                        <hr>
                        <document @getDocument="getDocument"></document>

                    </div>
                </div>

                <div class="row">
                    <div class="col-auto mr-auto"></div>
                    <div class="col-auto">
                        <button class="btn btn-primary btn-block" @click.prevent="createLoan">
                        <div class="spinner-border text-light spinner-border-sm" role="status" v-if="showSpinner">
                        </div>
                            Save
                    </button></div>
                </div>
            </div>
        </div>
    </div>

</template>

<script>
    import {createResource, getResource} from "../../../utils/resource";
    import Guarantor from "./guarantor"
    import Document from './documents'
    import LoanView from './view-loan'
    export default {
        mounted(){
          this.getProducts();
        },
        name: "load-details",
        components:{
            Guarantor,
            Document,
            LoanView
        },
        data(){
            return {
                showSpinner:false,
                loan:{
                    clientName:"",
                    clientPhoneNumber:"",
                    accountNumber:null,
                    amount:null,
                    purpose:null,
                    startDate:"",
                    endDate:"",
                    collateral:null,
                    sourceOfIncome:null,
                    product:{
                        id:null
                    },
                    comments:"",
                    insurancePremium: null,
                    commitmentFee: null,
                    status:"INITIATED",
                    documents:""

                },

                date: new Date(),
                dateOptions: {
                    format: 'DD/MM/YYYY',
                    useCurrent: false,
                },
                collateral:[
                    {value:null,text:"Type Of Collateral Offered"},
                    {value:"Mortgage Over Land and Buildings",text:"Mortgage Over Land and Buildings"},
                    {value:"Vehicle Registration Documents",text:"Vehicle Registration Documents"},
                    {value:"Lien Over Savings Account",text:"Lien Over Savings Account"},
                    {value:"Fixed Deposit Certificate", text:"Fixed Deposit Certificate"},
                    {value:"Stocks/Life Certificate",text:"Stocks/Life Certificate"},
                ],
                sourceofIncome:[
                    {value:null,text:"Source Of Income"},
                    {value:"Net Salary on PaySlip",text:"Net Salary on PaySlip"},
                    {value:"Regular Allowance not on Payslip",text:"Regular Allowance not on Payslip"},
                ],
                products:[
                    { value: null, text: 'Loan Product' },
                ],
                guarantors:[],
                guarantorImage:""
            }
        },
        methods:{
            async createLoan(){
                    this.showSpinner=true;
                const[ex,res]=await createResource("loan",this.loan);
                if(ex){
                    console.log(ex)
                }


                this.createGuarantor(res.data.id);

                window.location.href="/";

            },
          async   getProducts(){
                const [ex, products] = await getResource("products");
                 products.data.map((data) => {
                    this.products.push({
                        value: data["id"],
                        text: data["name"],
                    });
                })


            },
            async createGuarantor(Loanid){
                this.guarantors.map(async (guarantor)=>{
                    const[ex,res]=await  createResource("guarantor",
                        {
                            "firstName":guarantor["firstName"],
                            "middleName":guarantor["middleName"],
                            "surname":guarantor["surname"],
                            "mobileNumber":guarantor["mobileNumber"],
                            "houseNumber":guarantor['houseNumber'],
                            "relationship":guarantor["relationship"],
                            "loan":{
                                "id":Loanid
                            }});
                });

                // this.$bvToast.toast('Loan  Created', {
                //     variant: "success",
                //     solid: true,
                //     toaster:"b-toaster-bottom-left",
                //     autoHideDelay:100,
                //     noCloseButton:true
                // });
                this.showSpinner=false;

            },
            addGuarantor(guarantor){
                this.guarantors.push(guarantor);

            },

            getDocument(document){
                this.loan.documents=document;
            }

        }
    }
</script>

<style lang="scss" scoped>
    .row{
        margin-bottom: 20px;
        .form-row{
            margin-bottom: 12px;
        }
    }
    .card{
        margin-bottom:50px;
    }
</style>