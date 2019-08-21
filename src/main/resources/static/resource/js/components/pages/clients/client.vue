<template>
    <div>
                <div class="card shadow-sm">
                    <div class="card-header">
                        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center ">
                            <input class="form-control form-control-sm col-6 shadow-sm" placeholder="Search Loans">

                            <div class="dropdown">
                                <button class="btn btn-success shadow dropdown-toggle btn-block" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                  Create
                                </button>
                                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <a class="dropdown-item" href="/clients?type=individual">Individual</a>
                                    <a class="dropdown-item" href="#">Business</a>
                                </div>
                            </div>

                        </div>
                    </div>
                    </div>
                    <div class="card-body">


                    </div>
                </div>
</template>

<script>
    export default {
        name: "client",
        components: {},
        data() {
            return {
                show: false,
            }
        }
    }
</script>


<style lang="scss" scoped>
    .modal-dialog-centered {
        margin-top: -30px !important;
    }

</style>