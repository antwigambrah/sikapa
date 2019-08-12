<template>
    <div>
        <div class="card shadow-sm">
            <div class="card-body">
                <b-tabs content-class="mt-3" fill>
                    <b-tab title="Loan Details" active><p>Applicant Details</p></b-tab>
                    <b-tab title="Guarantors"><p>Guarantors</p></b-tab>
                    <b-tab title="Collaterals"><p>Collaterals</p></b-tab>
                    <b-tab title="Fees"><p>Fees</p></b-tab>
                    <b-tab title="Recommendations"><p>Recommendations</p></b-tab>
                    <b-tab title="Approvals"><p>Approvals</p></b-tab>
                </b-tabs>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "individual"
    }
</script>

<style scoped lang="scss">
.card-body{

}
</style>