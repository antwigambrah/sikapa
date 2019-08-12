<template>
    <div class="card shadow-sm">
        <div class="card-header">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center ">
                <input class="form-control form-control-sm col-6 shadow-sm" placeholder="Search Loans">
                <div class="spinner-border" role="status">
                    <span class="sr-only">Loading...</span>
                </div>
                <div class="btn-toolbar mb-2 mb-md-0">

                    <b-dropdown id="dropdown-1" text="new application" class="m-md-2" right variant="success">
                        <b-dropdown-item href="/loans?type=individual">Individual</b-dropdown-item>
                        <b-dropdown-item href="/loans?type=corporate">SME/Corporate</b-dropdown-item>
                    </b-dropdown>
                </div>
            </div>
        </div>
        <div class="card-body">


        </div>
    </div>
</template>

<script>
    export default {
        name: "loan",
        components:{
        },
        data(){
            return {
                show: false,
            }
        }
    }
</script>


<style lang="scss" scoped>
    .modal-dialog-centered{
        margin-top:-30px !important;
    }

</style>