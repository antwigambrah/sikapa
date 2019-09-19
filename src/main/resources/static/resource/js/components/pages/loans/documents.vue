<template>
        <div class="row">
            <div class="col-4">
                <h4>Documents</h4>
            </div>
            <div class="col-8">
                <label class="form-label">Choose</label>
                <div>
                    <b-form-file multiple :file-name-formatter="getFiles"></b-form-file>


                </div>
                <p>
                    Note: Only single files can be uploaded for now
                </p>

                </div>
        </div>
</template>

<script>
    export default {
        data(){
            return {
                file:[]
            }
        },
        methods:{

            getFiles(files) {
                let that=this;

                var reader  = new FileReader();

        reader.addEventListener("load", function () {
            that.$emit("getDocument",reader.result);
        }, false);

        if (files) {

            reader.readAsDataURL(files[0]);

          return files[0].name
        }
    }
        }
    }
</script>

<style lang="scss" scoped>

</style>