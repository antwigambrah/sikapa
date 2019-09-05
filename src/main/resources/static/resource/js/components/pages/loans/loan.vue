<template>
    <div>
            <div class="row">
        <div class="col-md-10 offset-md-1">
            <div class="card shadow-sm">
                <div class="card-header">
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center ">
                        <input class="form-control form-control-sm col-6 shadow-sm" placeholder="Search Loans">
                        <div class="btn-toolbar mb-2 mb-md-0">
                            <div class="dropdown">
                                <button class="btn btn-primary btn-blockdropdown-toggle " type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Create
                                </button>
                                <div class="dropdown-menu" aria-labelledby="New Application">
                                    <a class="dropdown-item" href="/loan/individual">Individual</a>
                                    <a class="dropdown-item" href="/loan/business">SME/Business</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card-body">


                </div>
            </div>
        </div>
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
        },
    }
</script>


<style lang="scss" scoped>
    .modal-dialog-centered{
        margin-top:-30px !important;
    }

</style>