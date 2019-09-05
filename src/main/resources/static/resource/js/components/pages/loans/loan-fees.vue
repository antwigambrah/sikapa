<template>
    <div>
        <div class="row">
            <div class="col-auto mr-auto">

            </div>
            <div class="col-auto">
                <button class="btn btn-block btn-primary" @click="modalShow=true">Add Fee</button>
            </div>
        </div>
        <b-modal title="Add Loan Fee" v-model="modalShow">
            <form>
                <div class="form-row">
                    <div class="col-6">
                        <label>Fee Name</label>
                        <input v-model="loanFee.name" type="text" class="form-control"  placeholder="Name">
                    </div>
                    <div class="col-6">
                        <label>Rate</label>
                        <div class="input-group mb-3">
                        <input v-model="loanFee.rate" type="text" class="form-control"  placeholder="Rate">
                        <div class="input-group-append">
                            <span class="input-group-text" id="basic-addon2">%</span>
                        </div>
                    </div>
                    </div>
                </div>

            </form>
            <div slot="modal-footer" class="w-100">
                <b-button
                        variant="primary"
                        size="block"
                        class="float-right"
                @click="createFee"
                >
                    submit
                </b-button>
            </div>
        </b-modal>

                    <b-table striped hover :items="items"></b-table>

    </div>
</template>

<script>
    import {createResource,getResource} from "../../../utils/resource";

    export default{
        mounted(){
          this.getFees();
        },
        data(){
            return {
                modalShow: false,
                loanFee: {
                    name: "",
                    rate: 0
                },
                items: []

            }
        },
        methods:{
            async getFees(){
              const[ex,res]= await  getResource("fees");
              if (ex){
                  console.log(ex)
              }

                this.items=res.data.map((fees)=>{
                    return{
                        "id":fees["id"],
                        "name":fees["name"],
                        "rate (%)":fees["rate"]
                    }
                })

            },
            async createFee(){
                const[ex,res]=  await  createResource("fees",this.loanFee);
                if (ex){
                    console.log(ex)
                }
                this.getFees();
                this.modalShow=false;
                this.$bvToast.toast('Loan Fee Created', {
                    variant: "success",
                    solid: true,
                    toaster:"b-toaster-bottom-left",
                    autoHideDelay:100,
                    noCloseButton:true
                });
            }
        }
    }
</script>