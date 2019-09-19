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

                <b-modal title="Edit User" v-model="modalShow" :hide-header-close="false">
                    <form>
                        <div class="form-group">
                            <input v-model="user.username" type="text" class="form-control" id="username"  placeholder="Username" >
                        </div>
                        <div class="form-group">
                        </div>
                        <div class="form-group">
                            <input v-model="user.password" type="password" class="form-control" id="password"  placeholder="******************">
                        </div>

                    </form>
                    <div slot="modal-footer" class="w-100">
                        <button class="btn btn-block btn-success float-right" @click="updateUser()">Update</button>
                    </div>
                </b-modal>
            </div>
            <div class="col-auto">
                <button class="btn btn-primary btn-block" @click="modalShow = true">Edit User</button>
            </div>
        </div>

    </div>
</template>

<script>
    import {getResource,updateResource} from "../../../utils/resource"
    export default {
        name: "profile",
      async mounted() {
            this.getUser();
        },
        data(){
            return {
                hideHeaderClose:false,
                modalShow: false,
                user:{
                    id:1,
                    username:"",
                    password:""
                }
            }
        },
        methods:{
           async  updateUser(){
                const[ex,res]=await updateResource("/auth/user/"+this.user.id,this.user);
               if (ex){
                   console.log(ex)
               }else {
                   this.modalShow=false;
                   this.getUser();
                   this.$bvToast.toast('user updated', {
                       variant: "success",
                       solid: true,
                       toaster:"b-toaster-bottom-left",
                       autoHideDelay:500,
                       noCloseButton:true
                   });
                   window.location.href="/login?logout"

               }
            },
            async getUser(){
                const [ex,res]=await getResource("/auth/user");
                if(ex){
                    console.log(ex)
                }else{

                    this.user.username=res.data.username;
                    this.user.id=res.data.id;
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