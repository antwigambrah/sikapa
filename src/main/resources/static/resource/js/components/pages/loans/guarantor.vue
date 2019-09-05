<template>
<div>
    <div class="row">
        <div class="col-4">
        <h4>Guarantor Details</h4>
        </div>
        <div class="col-8">
            <div class="form-row">
                    <div class="col-auto mr-auto"></div>
                    <div class="col-auto">
                        <button class="btn btn-primary btn-block" @click="showModal=true">Add +</button>
                    </div>
                </div>
            <div class="form-row">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Relationship</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr v-for="(value, key,index) in guarantors">
                        <td>{{value.firstName + value.middleName+ value.surname}}</td>
                        <td>{{value.relationship}}</td>
                        <td><button class="btn btn-danger" @click="removeGuarantor(index)"><i class="lni-pencil"></i></button></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <b-modal v-model="showModal"  title="Add Guarantor" :hide-footer="true">
                <form>
                    <div class="form-row">
                        <div class="col-6">
                            <label class="form-label">Firstname</label>
                            <input type="text" class="form-control" placeholder="Firstname" v-model="guarantor.firstName">
                        </div>
                        <div class="col-6">
                            <label class="form-label">Middlename</label>
                            <input type="text" class="form-control" placeholder="Middlename" v-model="guarantor.middleName">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col">
                            <label class="form-label">Lastname</label>
                            <input type="text" class="form-control" placeholder="surName" v-model="guarantor.surname">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-6">
                            <label class="form-label">Mobile Number</label>
                            <input type="text" class="form-control" placeholder="Mobile Number" v-model="guarantor.mobileNumber">
                        </div>
                        <div class="col-6">
                            <label class="form-label">House Number</label>
                            <input type="text" class="form-control" placeholder="House Number" v-model="guarantor.houseNumber">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col">
                            <label class="form-label">Relationship</label>
                            <b-form-select v-model="guarantor.relationship" :options="relationship"></b-form-select>
                        </div>
                    </div>
                    <div class="form-row footer-row">
                        <div class="col-auto mr-auto"></div>
                        <div class="col-auto">
                            <button class="btn btn-primary btn-block" @click.prevent="addGuarantor">
                                Save
                            </button>
                        </div>
                    </div>


                </form>
            </b-modal>
        </div>
    </div>

</div>
</template>

<script>
export default {
        components:{

        },
    data(){
        return {
            showModal:false,
            guarantor:{
                firstName:"",
                middleName:"",
                surname:"",
                mobileNumber:"",
                houseNumber:"",
                relationship:null,
                loan:{
                    id:null
                }
            },
            additionalComments:"",
            relationship:[
                {value:null,text:"RELATIONSHIP"},
            {value:"MOTHER",text:"MOTHER"},
            {value:"FATHER",text:"FATHER"},
            {value:"SISTER",text:"SISTER"},
            {value:"SISTER_IN_LAW",text:"SISTER_IN_LAW"},
            {value:"BROTHER_IN_LAW",text:"BROTHER_IN_LAW"},
            {value:"MOTHER_IN_LAW",text:"MOTHER_IN_LAW"},
            {value:"FATHER_IN_LAW",text:"FATHER_IN_LAW"},
            {value:"FRIEND",text:"FRIEND"}
            ],
            guarantors:[],
            guarantorsData:[],
            fields:["name","relationship"]
        }
    },
    methods:{
        addGuarantor(){
            this.guarantors.push(this.guarantor)
            this.$emit("guarantor",this.guarantor);
            this.guarantor={};
            this.showModal=false;
        },
        removeGuarantor(index){
            this.guarantors.slice(1,index);
        }

    },


}
</script>

<style lang="scss">
    .row{
        margin-bottom: 20px;
        .form-row{
            margin-bottom: 12px;
        }
    }
    .footer-row{
        margin-top:20px;
    }
</style>