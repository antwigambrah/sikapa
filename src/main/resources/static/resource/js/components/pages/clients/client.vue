<template>

    <div>
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center ">
            <input class="form-control form-control-sm col-6 shadow-sm" placeholder="Search Clients">
            <div class="btn-toolbar mb-2 mb-md-0">

                <b-dropdown id="dropdown-1" text="new client" class="m-md-2" right variant="success">
                    <b-dropdown-item href="/clients?type=individual">Individual</b-dropdown-item>
                    <b-dropdown-item href="/clients?type=corporate">SME/Corporate</b-dropdown-item>
                </b-dropdown>
            </div>
        </div>
        <div class="card shadow-sm">

            <div class="card-body">


            </div>
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