<template>
    <div>
        <div class="card shadow-sm">
            <div class="card-body">
                <div class="row">
                    <div class="col-4">
                        <h4>   Client</h4>
                    </div>
                    <div class="col-8">
                        <form>
                            <div class="form-row">
                                <div class="col-6">
                                    <label class="form-label">Firstname</label>
                                    <input type="text" class="form-control" placeholder="Firstname" v-model="client.firstName">
                                </div>
                                <div class="col-6">
                                    <label class="form-label">Middlename</label>
                                    <input type="text" class="form-control" placeholder="Middlename" v-model="client.middleName">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col">
                                    <label class="form-label">Lastname</label>
                                    <input type="text" class="form-control" placeholder="surName" v-model="client.surname">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-6">
                                    <label class="form-label">Gender</label>
                                    <b-form-select v-model="client.gender" :options="genderData"></b-form-select>
                                </div>
                                <div class="col-6">
                                    <label class="form-label">Marital Status</label>
                                    <b-form-select v-model="client.maritalStatus" :options="maritalStatusData"></b-form-select>
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="col">
                                    <label class="form-label">Date Of Birth</label>
                                    <date-picker v-model="client.dateOfBirth" :config="options"></date-picker>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-6">
                                    <label class="form-label">Place Of Birth</label>
                                    <input type="text" class="form-control" placeholder="Place Of Birth" v-model="client.placeOfBirth">
                                </div>
                                <div class="col-6">
                                    <label class="form-label">Nationality</label>
                                    <b-form-select v-model="client.nationality" :options="countries"></b-form-select>

                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col">
                                    <label class="form-label">Occupation</label>
                                    <input type="text" class="form-control" placeholder="Occupation" v-model="client.occupation">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-6">
                                    <label class="form-label">Phone Number</label>
                                    <input type="text" class="form-control" placeholder="Phone Number" v-model="client.individual.phoneNumber">
                                </div>
                                <div class="col-6">
                                    <label class="form-label">Email</label>
                                    <input type="text" class="form-control" placeholder="Email" v-model="client.individual.email">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col">
                                    <label class="form-label">Postal Address</label>
                                    <input type="text" class="form-control" placeholder="Postal Address" v-model="client.individual.postalAddress">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-6">
                                    <label class="form-label">Town</label>
                                    <input type="text" class="form-control" placeholder="Town" v-model="client.individual.town">
                                </div>
                                <div class="col-6">
                                    <label class="form-label">House Number</label>
                                    <input type="text" class="form-control" placeholder="House Number" v-model="client.individual.houseNumber">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col">
                                    <label class="form-label">Nearest Landmark</label>
                                    <input type="text" class="form-control" placeholder="Nearest Landmark" v-model="client.individual.nearestLandmark">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-4">
                                    <label class="form-label">Accomodation </label>
                                    <b-form-select v-model="client.individual.tenancyType" :options="tenancyTypeData"></b-form-select>
                                </div>
                                <div class="col-4">
                                    <label class="form-label">Years At Residence</label>
                                    <input type="number" class="form-control" placeholder="Years" v-model="client.individual.tenancyDuration">
                                </div>
                                <div class="col-4">
                                    <label class="form-label">No. Of Dependants</label>
                                    <input type="number" class="form-control" placeholder="Dependants" v-model="client.individual.numberOfDependants">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-6">
                                    <label class="form-label">ID Number</label>
                                    <input type="text" class="form-control" placeholder="Id Number" v-model="client.individual.idNumber" >
                                </div>
                                <div class="col-6">
                                    <label class="form-label">Gps Address</label>
                                    <input type="text" class="form-control" placeholder="Gps Address" v-model="client.individual.gpsAddress">

                                </div>


                            </div>
                            <div class="form-row">
                                <div class="col">
                                    <label class="form-label">Next Of Kin</label>
                                    <input type="text" class="form-control" placeholder="Nest Of Kin" v-model="client.nextOfKin">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col">
                                    <label class="form-label">Branch</label>

                                    <div class="form-group">
                                        <b-form-select v-model="client.branch.id" :options="branchData"></b-form-select>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div class="row last-row">
            <div class="col-auto mr-auto"></div>
            <div class="col-auto">
                <button type="submit" class="btn btn-primary btn-block"  v-if="showSpinner" >
                    Saving  <span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>

                </button>
                <button type="submit" class="btn btn-primary btn-block shadow-lg" @click.prevent="saveClient" v-else  >
                    Save  <i class="lni-arrow-right"> </i>

                </button>

            </div>
        </div>


    </div>

</template>

<script>
    import {countries} from '../../../utils/countries'
    import {getResource,createResource} from "../../../utils/resource";

    export default {
        async mounted(){
            const[ex,res]= await  getResource("users");
            console.log(res);
            this.getBranches();
        },
        name: "individual",
        data(){
            return {
                showSpinner:false,
                client:{
                    firstName:"",
                    middleName:"",
                    surname:"",
                    gender:null,
                    maritalStatus:null,
                    dateOfBirth:"",
                    placeOfBirth:"",
                    nextOfKin:"",
                    nationality:"",
                    occupation:"",
                    branch:{
                        id:null
                    },
                    individual:{
                        phoneNumber:"",
                        email:"",
                        numberOfDependants:0,
                        houseNumber:"",
                        town:"",
                        postalAddress:"",
                        nearestLandmark:"",
                        gpsAddress:"",
                        tenancyType:null,
                        tenancyDuration:0,
                        accountNumber:"5512223333",
                        idNumber:"",
                    },

                },
                branchData:[
                    { value: null, text: 'Branch' },
                ],
                genderData: [
                    { value: null, text: 'Gender' },
                    { value: 'MALE', text: 'MALE' },
                    { value: 'FEMALE', text: 'FEMALE'},
                ],
                maritalStatusData:[
                    {value:null,text:'Marital Status'},
                    {value:'SINGLE',text:'SINGLE'},
                    {value:'FEMALE',text:'FEMALE'},
                    {value:'DIVORCED',text:'DIVORCED'}
                ],
                tenancyTypeData:[
                    {value:null,text:'Accomodation'},
                    {value:'OWNED',text:'OWNED'},
                    {value:'RENTED',text:'RENTED'}
                ],
                date: new Date(),
                options: {
                    format: 'DD/MM/YYYY',
                    useCurrent: false,
                }

            }
        },
        computed:{
            countries(){
                return countries.map((country)=>{
                    return { value:country.name,text:country.name}
                })
            },

        },
        methods:{
            async saveClient(){
                //TODO SHOW ERROR MESSAGE BASED ON STATUS CODE
                // CLIENT SIDE VALIDATION
                this.showSpinner=true;
                const [ex,res]= await  createResource("/clients/individual",this.client);
                if(ex){
                    this.showSpinner=false;
                    this.$bvToast.toast('Error', {
                        variant: "danger",
                        solid: true,
                        toaster:"b-toaster-bottom-left",
                        noCloseButton:false
                    })
                }else{
                    this.showSpinner=false;
                    this.$bvToast.toast('Client Created', {
                        variant: "success",
                        solid: true,
                        toaster:"b-toaster-bottom-left",
                        noCloseButton:false
                    })
                    this.client={}

                }
            },
            async getBranches(){
                const[ex,res]= await getResource("branches");
                if (ex){
                    console.log(ex)
                } else {
                    res.data.map((branch)=>{
                        this.branchData.push( {
                            value: branch["id"],
                            text: branch["area"]
                        });
                    })
                }


            }
        }
    }
</script>

<style scoped lang="scss">
    .caret{
        color: #000000;
    }
    .card{
        .card-body{
            .form-row{
                margin-bottom:12px;
            }
        }
        margin-bottom: 10px;
    }

    h4{
        font-weight: bold;
    }

</style>
