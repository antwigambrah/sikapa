<template>
        <div class="row">
            <div class="col-4">
                <h4>Documents</h4>
            </div>
            <div class="col-8">
                <label class="form-label">Choose</label>
                <div>
                    <b-form-file multiple :file-name-formatter="formatNames"></b-form-file>


                </div>
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
            formatNames(files) {
                console.log(files)
                if (files.length === 1) {
                    return files[0].name
                } else {
                    return `${files.length} files selected`
                }
            }
        }
    }
</script>

<style lang="scss" scoped>

</style>