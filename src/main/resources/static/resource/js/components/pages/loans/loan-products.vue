<template>
        <div>
            <div class="row">
                <div class="col-auto mr-auto">

                </div>
                <div class="col-auto">
                    <button class="btn btn-block btn-primary" @click="modalShow=true">Add Product</button>
                </div>
            </div>
            <b-modal title="Add Loan Product" v-model="modalShow">
                <form>
                    <div class="form-group">
                        <label>Product Name</label>
                        <input v-model="loanProduct.name" type="text" class="form-control"  placeholder="Name">
                    </div>
                    <div class="form-row">
                        <div class="col-6">
                            <div class="form-group">
                                <label>Minimum Amount</label>
                                <input v-model="loanProduct.minimumAmount" type="number" class="form-control"  placeholder="Minimum Amount">
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="form-group">
                                <label >Maximum Amount</label>
                                <input v-model="loanProduct.maximumAmount" type="number" class="form-control"  placeholder="Maximum Amount">
                            </div>
                        </div>

                    </div>
                    <div class="form-row">
                        <div class="col-6">
                           <label>Repayment Period</label>
                            <div class="input-group mb-3">
                            <input v-model="loanProduct.repaymentPeriod" type="number" class="form-control"  placeholder="Repayment Period">
                            <div class="input-group-append">
                                <span class="input-group-text">months</span>
                            </div>
                            </div>
                        </div><div class="col-6">
                           <label>Interest Rate</label>
                            <div class="input-group mb-3">
                            <input v-model="loanProduct.interestRate" type="number" class="form-control"  placeholder="Repayment Period">
                            <div class="input-group-append">
                                <span class="input-group-text">%</span>
                            </div>
                            </div>
                        </div>

                    </div>
                </form>
                <div slot="modal-footer" class="w-100">
                    <b-button
                            variant="primary"
                            size="block"
                            class="float-right" @click="createProduct"
                    >
                        submit
                    </b-button>
                </div>
            </b-modal>

            <b-table striped hover :items="products"></b-table>
        </div>
</template>

<script>
    import {getResource,createResource} from "../../../utils/resource";

    export default{
      async  mounted(){
            this.getProducts();

        },
        data(){
            return {
                modalShow:false,
                loanProduct:{
                  name:"",
                    minimumAmount:0,
                    maximumAmount:0,
                    repaymentPeriod:0,
                    interestRate:0

                },
                products: [],
            }
        },
        methods:{
            async  createProduct(){
                const [ex,res]= await  createResource("products",{
                    "name":this.loanProduct.name,
                    "minimumAmount":this.loanProduct.minimumAmount,
                    "maximumAmount":this.loanProduct.maximumAmount,
                    "repaymentPeriod":this.loanProduct.repaymentPeriod,
                    "interestRate":this.loanProduct.interestRate
                });
                this.getProducts();
                this.modalShow=false;
                this.$bvToast.toast('Loan Product Created', {
                    variant: "success",
                    solid: true,
                    toaster:"b-toaster-bottom-left",
                    autoHideDelay:100,
                    noCloseButton:true
                });
                this.loanProduct={}
            },
            async  getProducts() {
                const [ex, products] = await getResource("products");
                console.log(products)
                this.products = products.data.map((data) => {
                    return {
                        "id": data["id"],
                        "name": data["name"],
                        "minimumAmount": data["minimumAmount"],
                        "maximumAmount": data["maximumAmount"],
                        "repaymentPeriod": data["repaymentPeriod"],
                        "interestRate":data["interestRate"],
                        "monthlyRate":data["interestRate"]/12
                    }
                })
            },
      }
        }
</script>