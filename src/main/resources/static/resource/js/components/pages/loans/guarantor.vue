<template>
<div>
    <div class="row">
        <div class="col-4">
        <h4>Guarantor Details</h4>
        </div>
        <div class="col-8">
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
                        <input type="text" class="form-control" placeholder="surName" v-model="guarantor.surName">
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
                        <input type="text" class="form-control" placeholder="surName" v-model="guarantor.surName">
                    </div>
                </div>

            </form>
        </div>
    </div>
    <hr>
    <div class="row">
        <div class="col-4">
            <h4>Comments</h4>
        </div>
        <div class="col-8">
            <label class="form-label">Comments</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" v-model="additionalComments"></textarea>

        </div>
    </div>
</div>
</template>

<script>
export default {
    data(){
        return {
            guarantor:{
                firstName:"",
                middleName:"",
                surName:"",
                mobileNumber:"",
                houseNumber:"",
                relationship:""
            },
            additionalComments:""
        }
    }

}
</script>

<style lang="scss">
    .row{
        margin-bottom: 20px;
        .form-row{
            margin-bottom: 12px;
        }
    }
</style>