<template>
    <div>
        <ul class="list-group shadow-sm">
            <li class="list-group-item">
                <div class="row justify-content-between">
                    <div class="col-4 title">
                       Name
                    </div>
                    <div class="col-4">
                        {{user.username}}
                    </div>
                </div>
            </li>

            <li class="list-group-item">
                <div class="row justify-content-between">
                    <div class="col-4 title">
                        Password
                    </div>
                    <div class="col-4">
                        ***************************
                    </div>
                </div>
            </li>
        </ul>

        <div class="row edit-row">
            <div class="col-auto mr-auto">

                <b-modal title="Edit User" v-model="modalShow">
                    <form>
                        <div class="form-group">
                            <input v-model="user.username" type="text" class="form-control" id="username"  placeholder="Username" >
                        </div>
                        <div class="form-group">
                        </div>
                        <div class="form-group">
                            <input v-model="user.password" type="text" class="form-control" id="password"  placeholder="******************">
                        </div>

                    </form>
                    <div slot="modal-footer" class="w-100">
                        <b-button
                                variant="success"
                                size="sm"
                                class="float-right"
                                @click="createUser()"
                        >
                            update
                        </b-button>
                    </div>
                </b-modal>
            </div>
            <div class="col-auto">
                <button class="btn btn-success btn-sm" @click="modalShow = true">Edit User</button>
            </div>
        </div>

    </div>
</template>

<script>
    export default {
        name: "profile",
        mounted() {
            axios.get('/user').then((res)=>{
                this.user.username=res.data.username;
            })
        },
        data(){
            return {
                modalShow: false,
                user:{
                    username:"",
                    password:""
                }
            }
        }
    }
</script>

<style lang="scss" scoped>
    .list-group{
        border-color:transparent;
        color:#294661;
        .list-group-item{
            border-color: #f8f9fa;
            .title{
                font-weight: bolder;
            }
        }
    }
    .edit-row{
        margin-top: 10px;
    }

</style>