<template>
<div>
  <div class="back">
     <h1>{{person.name}}님의 Mypage</h1></div>
      <div class="sub">
        <div class="pull-left rt size" >
           <fieldset style=" margin-top: 1%; height: 31.5%;border: 2px solid black;">
             <legend><h3>비밀번호</h3></legend>
             <h3>{{person.passwd}}</h3>
             <button>수정</button><br/><br/>
           </fieldset>
           <fieldset style="margin-top: 1%; height: 60%;border: 2px solid black;">
              <legend><h3>성적보기</h3></legend>
                <h5>{{person.hak}}학년</h5>
                <h5>{{person.ban}}반</h5>
                <h5>{{person.score}}점</h5>
                <br/><br/>
                <!-- <button @click.prevent="goUpdate">수정하러가기</button> -->
           </fieldset>
        </div>
      </div>
</div>
</template>
<script>
import {store} from '../../store'
//{store} -> 객체 destructuring

// import AuthLayout from '@/components/cmm/AuthLayout.vue'
export default {
  // components : {AuthLayout},
	data(){
		return{
      person : store.state.person
		}
	},
	create(){//hook methods !! 마이페이지 오자마자 바로 할 동작 처리 
  }
  // methods : {
  //     goUpdate(){
  //       this.$router.push({path : 'mypageUpdate'})
  //     }
  // }
}
</script>
<style scoped>
h1{
  text-align : center;
}
.back {width: 700px; margin: 0 ;}
.sub {width: 100%; height: 600px; margin: 0 auto; text-align: center;}
.pull-left {float: left;}
.pull-right {float: right;}
.top {margin-top: 1%;}
.rt {margin-right: 1%;}
.size {width: 49.5%; height: 100%;}
</style>