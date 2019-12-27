<template>
<div>
     <a @click.prevent="logout">로그아웃</a>
     <a @click.prevent="withdraw">회원탈퇴</a>
</div>
</template>
<script>
import {store} from '@/store'
import axios from 'axios'
export default {
    data(){
        return {
            context : 'http://localhost:8080/'
        }
    },
    methods : {
        logout(){
            alert('로그아웃 클릭')
            store.state.person.userid = ''
            store.state.authCheck = false
            store.state.sidebar = 'preSidebar'
            this.$router.push({path : '/login'})
        },
        withdraw(){
        alert('회원탈퇴')
        axios
        .delete(`${this.context}/withdraw/${store.state.person.userid}`)
        .then(()=>{
          alert('회원탈퇴 성공')
          this.$router.push({path : '/'})
        })
        .catch(()=>{
          alert('axios실패')
        })
        }
    }
}
</script>
<style scoped>

</style>