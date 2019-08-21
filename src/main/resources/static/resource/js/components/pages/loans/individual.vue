<template>
<div>
    <div class="row last-row">
        <div class="col-md-10 offset-md-1">
            <div class="row step-row">
                <div class="col-auto mr-auto"></div>
                <div class="col-auto">
                    <button class="btn btn-primary btn-block" @click.prevent="saveLoan()" v-if="nextTick===0">Save <i class="lni-arrow-right"></i></button>
                    <button class="btn btn-primary btn-block" @click="next" v-else> Next <i class="lni-arrow-right"></i></button>
                </div>
            </div>
            <div class="card shadow-sm">
                          <div class="card-body">
                              <component v-bind:is="viewComponent"></component>
                          </div>
                    </div>
                </div>
            </div>
        </div>
</template>

<script>
import Guarantor from "./guarantor"
import LoanDetails from "./load-details"
import Collateral from "./collateral"
    export default {
        name: "individual",
        components:{

        },
        data(){
            return {
                nextTick:1,
                isLoanDetails:true,
                isGuarantor:false,
                isCollateral:false,
                isComments:false
            }
        },
        computed:{
            viewComponent(){
                if (this.nextTick===1){
                    return LoanDetails;
                } else if(this.nextTick===2){
                    return Collateral
                } else if (this.nextTick===3) {
                    this.nextTick=0;
                    return Guarantor;

                }
            },
        },
        methods:{
            next(){
                this.nextTick++;
            },
            saveLoan(){}

        }
    }
</script>

<style scoped lang="scss">
.step-row{
    margin-bottom:10px;

}
</style>