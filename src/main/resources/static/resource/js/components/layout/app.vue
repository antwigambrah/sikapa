<template>

    <div>
        <div class="container-fluid">
            <div class="row">
                <side-bar></side-bar>
                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">

                    <slot>

                    </slot>

                </main>
            </div>
        </div>
    </div>

</template>

<script type="text/javascript">
    import NavBar from "../layout/nav"
    import SideBar from "../layout/sidebar"
    export default {
        components:{
            NavBar,
            SideBar
        }
    }
</script>