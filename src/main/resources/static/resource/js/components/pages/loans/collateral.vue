<template>
    <div>
        <div class="row last-row">
            <div class="col-4">
                <h4>Sources Of Income</h4>
            </div>
            <div class="col-8">
                <form>
                    <div class="form-row">
                        <div class="col-8">
                            <label class="form-label">Source Of Income</label>
                            <b-form-select v-model="sourceOfIncome.source" :options="sourceOfIncome.data"></b-form-select>
                        </div>
                        <div class="col-2">
                            <label class="form-label">Amount</label>
                            <input type="number" class="form-control" placeholder="Amt" v-model="sourceOfIncome.amount">
                        </div>
                        <div class="col-2">
                            <label class="form-label"></label>
                            <button class="btn btn-primary btn-block no-label-btn" @click.prevent="addSourceOfIncome">Add</button>
                        </div>

                    </div>
                    <div class="form-row">
                        <div class="col-10">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th scope="col">No.</th>
                                    <th scope="col">Source</th>
                                    <th scope="col">Amount</th>
                                    <th scope="col"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr v-for="(item,index) in sourceOfIncome.tableData">
                                    <th>{{index+1}}</th>
                                    <td>{{item.source}}</td>
                                    <td>{{item.amount}}</td>
                                    <td><button class="btn btn-danger btn-sm">remove</button></td>
                                </tr>

                                </tbody>
                            </table>
                        </div>
                        <div class="col-2">

                        </div>
                    </div>

                    <div class="form-row">
                        <div class="col-8">
                            <label class="form-label">Others (Specify)</label>
                            <input type="text" class="form-control" placeholder="Others (Specify)" v-model="sourceOfIncome.other.source">
                        </div>
                        <div class="col-2">
                            <label class="form-label">Amount</label>
                            <input type="number" class="form-control" placeholder="Amount" v-model="sourceOfIncome.other.amount">
                        </div>
                        <div class="col-2">
                            <label class="form-label"></label>
                            <button class="btn btn-primary btn-block no-label-btn" @click.prevent="addotherSourceOfIncome">Add</button>
                        </div>

                    </div>

                </form>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-4">
                <h4>Collateral</h4>
            </div>
            <div class="col-8">
                <form>
                    <div class="form-row">
                        <div class="col-8">
                            <label class="form-label">Type Of Collateral</label>
                            <b-form-select v-model="collateral.type" :options="collateral.data"></b-form-select>
                        </div>
                        <div class="col-2">
                            <label class="form-label">Value</label>
                            <input type="number" class="form-control" placeholder="Value" v-model="collateral.value">
                        </div>
                        <div class="col-2">
                            <label class="form-label"></label>
                            <button class="btn btn-primary btn-block no-label-btn" @click.prevent="addCollateral">Add</button>
                        </div>

                    </div>

                    <div class="form-row">
                        <div class="col-10">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th scope="col">No.</th>
                                    <th scope="col">Type</th>
                                    <th scope="col">Value</th>
                                    <th scope="col"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr v-for="(item,index) in collateral.tableData">
                                    <th>{{index+1}}</th>
                                    <td>{{item.type}}</td>
                                    <td>{{item.value}}</td>
                                    <td><button class="btn btn-danger btn-sm">remove</button></td>
                                </tr>

                                </tbody>
                            </table>
                        </div>
                        <div class="col-2">

                        </div>
                    </div>


                    <div class="form-row">
                        <div class="col-8">
                            <label class="form-label">Others (Specify)</label>
                            <input type="text" class="form-control" placeholder="Others (Specify)" v-model="collateral.other.type">
                        </div>
                        <div class="col-2">
                            <label class="form-label">Value</label>
                            <input type="text" class="form-control" placeholder="Amount" v-model="collateral.other.value">
                        </div>
                        <div class="col-2">
                            <label class="form-label"></label>
                            <button class="btn btn-primary btn-block no-label-btn" @click.prevent="addOtherCollateral">Add</button>
                        </div>

                    </div>


                </form>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-4">
                <h4>Expenses</h4>
            </div>
            <div class="col-8">
                <form>
                    <div class="form-row">
                        <div class="col-8">
                            <label class="form-label">Type Of Expense</label>
                            <b-form-select v-model="expenses.type" :options="expenses.data"></b-form-select>
                        </div>
                        <div class="col-2">
                            <label class="form-label">Amount</label>
                            <input type="number" class="form-control" placeholder="Amount" v-model="expenses.amount">
                        </div>
                        <div class="col-2">
                            <label class="form-label"></label>
                            <button class="btn btn-primary btn-block no-label-btn" @click.prevent="addExpense">Add</button>
                        </div>

                    </div>

                    <div class="form-row">
                        <div class="col-10">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th scope="col">No.</th>
                                    <th scope="col">Type</th>
                                    <th scope="col">Value</th>
                                    <th scope="col"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr v-for="(item,index) in expenses.tableData">
                                    <th>{{index+1}}</th>
                                    <td>{{item.type}}</td>
                                    <td>{{item.amount}}</td>
                                    <td><button class="btn btn-danger btn-sm">remove</button></td>
                                </tr>

                                </tbody>
                            </table>
                        </div>
                        <div class="col-2">

                        </div>
                    </div>


                    <div class="form-row">
                        <div class="col-8">
                            <label class="form-label">Others (Specify)</label>
                            <input type="text" class="form-control" placeholder="Others (Specify)" v-model="expenses.other.type">
                        </div>
                        <div class="col-2">
                            <label class="form-label">Value</label>
                            <input type="text" class="form-control" placeholder="Amount" v-model="expenses.other.amount">
                        </div>
                        <div class="col-2">
                            <label class="form-label"></label>
                            <button class="btn btn-primary btn-block no-label-btn" @click.prevent="addOtherExpense">Add</button>
                        </div>

                    </div>


                </form>
            </div>
        </div>

    </div>
</template>

<script>
    export default {
        name: "collateral",
        data(){
            return {
                sourceOfIncome:{
                    source:null,
                    amount:0,
                    data:[
                        {value:null,text:"Source Of Income"},
                        {value:"Net Salary on PaySlip",text:"Net Salary on PaySlip"},
                        {value:"Regular Allowance not on Payslip",text:"Regular Allowance not on Payslip"},
                    ],
                    tableData:[],
                    other:{
                        source:null,
                        amount:0,
                        data:[]
                    }


                },
                collateral:{
                    type:null,
                    value:0,
                    data:[
                        {value:null,text:"Type Of Collateral Offered"},
                        {value:"Mortgage Over Land and Buildings",text:"Mortgage Over Land and Buildings"},
                        {value:"Vehicle Registration Documents",text:"Vehicle Registration Documents"},
                        {value:"Lien Over Savings Account",text:"Lien Over Savings Account"},
                        {value:"Fixed Deposit Certificate", text:"Fixed Deposit Certificate"},
                        {value:"Stocks/Life Certificate",text:"Stocks/Life Certificate"},
                    ],
                    tableData:[],
                    other:{
                        type:null,
                        value:0
                    }
                },
                expenses:{
                    type:null,
                    amount:0,
                    data:[
                        {value:null,text:"Type Of Expense"},
                        {value:"Insurance Premiums",text:"Insurance Premiums"},
                        {value:"Standing Orders",text:"Standing Orders"},
                    ],
                    tableData:[],
                    other:{
                        type:null,
                        amount:0
                    }
                }
            }
        },
        methods:{
            addSourceOfIncome(){
                this.sourceOfIncome.tableData.push({
                    "source":this.sourceOfIncome.source,
                    "amount":this.sourceOfIncome.amount
                })
            },
            addotherSourceOfIncome(){
                this.sourceOfIncome.tableData.push({
                    "source":this.sourceOfIncome.other.source,
                    "amount":this.sourceOfIncome.other.amount
                })
            },
            addCollateral(){
                this.collateral.tableData.push({
                    "type":this.collateral.type,
                    "value":this.collateral.value
                });
            },
            addOtherCollateral(){
                this.collateral.tableData.push({
                    "type":this.collateral.other.type,
                    "value":this.collateral.other.value
                })
            },
            addExpense(){
                this.expenses.tableData.push(({
                    "type":this.expenses.type,
                    "amount":this.expenses.amount
                }))
            },
            addOtherExpense(){
                this.expenses.tableData.push({
                    "type":this.expenses.other.type,
                    "amount":this.expenses.amount
                })
            }

        }
    }
</script>

<style lang="scss" scoped>
.no-label-btn{
    margin-top:7px;
}
</style>