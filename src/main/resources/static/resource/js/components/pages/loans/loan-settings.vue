<template>
<div class="card shadow-sm">
 <div class="card-body">
 <div class="row">
  <div class="col-3">
    <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
      <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true">Product</a>
    </div>
  </div>
  <div class="col-9">
    <div class="tab-content" id="v-pills-tabContent">
      <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
          <loan-product></loan-product>
      </div>

    </div>
  </div>
</div>
 </div>
</div>
</template>

<script>
    import LoanProduct from './loan-products'
    import LoanFee from './loan-fees'
export default {
    name:"loansettings",
    components:{
        LoanProduct,
        LoanFee
    }

}
</script>

<style lang="scss" scoped>
.col-3{
    border-right:1px solid #dee2e6;
}
</style>