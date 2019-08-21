<template>
    <div>
        <div class="row">
            <div class="col-4">
                <h4>Link Account</h4>
            </div>
            <div class="col-8 ">
                <form>
                    <div class="form-row">
                        <div class="col">
                            <label class="form-label">Client Account</label>
                            <input type="text" class="form-control" placeholder="Account" v-model="accountNumber">
                        </div>
                    </div>

                </form>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-4">
                <h4>Existing Loan</h4>
            </div>
            <div class="col-8 ">
                <form>
                    <div class="form-row">
                        <div class="col">
                            <label class="form-label">Amount</label>
                            <input type="text" class="form-control" placeholder="Amount" v-model="existingLoan.amount">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-6">
                            <label class="form-label">Repayment Amount</label>
                            <input type="text" class="form-control" placeholder="Repayment Amount" v-model="existingLoan.repaymentAmount">
                        </div>
                        <div class="col-6">
                            <label class="form-label">Outstanding Amount</label>
                            <input type="text" class="form-control" placeholder="Outstanding Amount" v-model="existingLoan.outstandingAmount">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-6">
                            <label class="form-label">Start Date</label>
                            <date-picker v-model="existingLoan.date.start" :config="existingLoan.date.options"></date-picker>
                        </div>
                        <div class="col-6">
                            <label class="form-label">End Date</label>
                            <date-picker v-model="existingLoan.date.end" :config="existingLoan.date.options"></date-picker>
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
                        <div class="col">
                            <label class="form-label">Amount</label>
                            <input type="text" class="form-control" placeholder="Amount" v-model="loan.amount">
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
                                <date-picker v-model="loan.date.start" :config="loan.date.options"></date-picker>
                            </div>
                            <div class="col-6">
                                <label class="form-label">End Date</label>
                                <date-picker v-model="loan.date.end" :config="loan.date.options"></date-picker>
                            </div>
                    </div>

                </form>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-4">
                <h4>Account Conduct</h4>
            </div>
            <div class="col-8 ">
                <form>
                    <div class="form-row">
                        <div class="col-6">
                            <label class="form-label">Credit Turnover</label>
                            <input type="text" class="form-control" placeholder="Amount" v-model="accountConduct.creditTurnover">
                        </div>
                        <div class="col-6">
                            <label class="form-label">Debit Turnover</label>
                            <input type="text" class="form-control" placeholder="Amount" v-model="accountConduct.debitTurnover">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col">
                            <label class="form-label">Lowest Turnover</label>
                            <input type="text" class="form-control" placeholder="Amount" v-model="accountConduct.lowestTurnover">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-6">
                            <label class="form-label">Highest Balance</label>
                            <input type="text" class="form-control" placeholder="Amount" v-model="accountConduct.highestBalance">
                        </div>
                        <div class="col-6">
                            <label class="form-label">Actual Balance</label>
                            <input type="text" class="form-control" placeholder="Amount" v-model="accountConduct.actualBalance">
                        </div>
                    </div>

                </form>
            </div>
        </div>

    </div>
</template>

<script>
    export default {
        name: "load-details",
        data(){
            return {
                accountNumber:null,
                existingLoan:{
                    amount:0,
                    repaymentAmount:0,
                    outstandingAmount:0,
                    date:{
                        start:new Date(),
                        end:new Date(),
                        options:{
                            format: 'DD/MM/YYYY',
                            useCurrent: false,
                        }
                    }
                },
                loan:{
                    amount:0,
                    purpose:null,
                    date:{
                        start:new Date(),
                        end:new Date(),
                        options:{
                            format: 'DD/MM/YYYY',
                            useCurrent: false,
                        }
                    }

                },
                accountConduct:{
                    creditTurnover:0,
                    debitTurnover:0,
                    lowestTurnover:0,
                    highestBalance:0,
                    actualBalance:0

                }
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
</style>