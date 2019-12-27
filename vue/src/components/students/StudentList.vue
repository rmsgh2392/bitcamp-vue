<template>
	<div>학생들 목록 
	<table class="table"><tr>
	<th>No.</th><th>아이디</th><th>비번</th><th>이름</th><th>생년월일</th>
	<th>성별</th><th>학년</th><th>반</th><th>점수</th><th>역할</th>
	</tr>
	<tr v-for="(j, i) of list" :key="j.id">
	<td>{{i+1}}</td>
	<td>{{j.userid}}</td>
	<td>{{j.passwd}}</td>
	<td>{{j.name}}</td>
	<td>{{j.birthday}}</td>
	<td>{{j.male}}</td>
	<td>{{j.hak}}</td>
	<td>{{j.ban}}</td>
	<td>{{j.score}}</td>
	<td>{{j.role}}</td>
	</tr>
	</table>
	</div>
</template>
<script>
import axios from 'axios'
export default {
	data(){
		return {
			context : 'http://localhost:8080/',
			list : []
	}
	},
	created(){
		axios
		.get(`${this.context}/students`)
		.then(res=>{
			this.list = res.data
			alert(`회원수 : ${res.data.length}`)
		})
		.catch(()=>{
			alert('axios실패')
		})
	}
}
</script>
<style scoped>
#tab{
	border : 3px solid lavender ;
	height : 400px;
	width : 100%;
	border-radius : 50px;
}
#tab tr{border : 1px solid black ;}
#tab tr th{border : 1px solid black ; padding : 10px; border-collapse : collapse; text-align : right;}
#tab tr td {border : 1px solid black ; text-align : right;}
</style>