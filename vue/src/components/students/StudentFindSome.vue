<template>
<div>
	<div class="login-form">    
    <form >
    	<h4 class="modal-title">검색해볼까</h4>
		<select name="role" style="float : right;" >
			<option value="">선생</option>
			<option value="">학생</option>
		</select>
        <div class="form-group">
            <input  type="text" class="form-control" placeholder="Username" required="required">
        </div>
        <input type="submit" class="btn btn-primary btn-block btn-lg" value="빨리찾아 " @click.prevent="find">
		<a @click.prevent="pratice('namesOfStudents')">1. 학생의 이름</a><br/>
		<a @click.prevent="pratice('streamToArray')">2. 스트림을 배열로 전환</a><br/>
		<a @click.prevent="pratice('streamToMap')">3. 스트림을 맵으로 전환. 학생이름이  key</a><br/>
		<a @click.prevent="pratice('theNumberOfStudents')">4. 학생의 수</a><br/>
		<a @click.prevent="pratice('totalScore')">5. 학생들 총점</a><br/>
		<a @click.prevent="pratice('topStudent')">6. 1등 학생</a><br/>
		<a @click.prevent="pratice('getStat')">7. 전체 학생 성적 통계</a><br/>
		<a @click.prevent="pratice('nameList')">8. 전체 학생 이름</a><br/>
		<a @click.prevent="pratice('partioningBy')">1.단순분할 (성별로 분할)</a><br/>
		<a @click.prevent="pratice('partioningCountPerGender')">2.단순분할 (성별 학생수)</a><br/>
		<a @click.prevent="pratice('partioningTopPerGender')">3.단순분할 (성별 1등)</a><br/>
		<a @click.prevent="pratice('partioningRejectPerGender')">4.다중분할 (성별 불합격자,  50점이하)</a><br/>
		<a @click.prevent="pratice('groupingByBan')">1. 단순 그룹화(반별로 그룹화)</a><br/>
		<a @click.prevent="pratice('groupingByGrade')">2. 단순그룹화(성적별로 그룹화)</a><br/>
		<a @click.prevent="pratice('groupingByCountByLevel')">3. 단순그룹화 + 통계(성적별 학생수))</a><br/>
		<a @click.prevent="pratice('groupingByHakAndBan')">4. 다중 그룹화 (학년별, 반별)</a><br/>
		<a @click.prevent="pratice('groupingTopByHakAndBan')">5. 다중 그룹화 +통계 (학년별, 반별  1등)</a><br/>
		<a @click.prevent="pratice('groupingByStat')">6. 다중그룹화 + 통계(학년별, 반별  성적그룹)</a><br/>         
    </form>		
	<h2>학생 조건 검색 결과</h2>
	<div v-for="(item, index) of list" :key="item">
		<div class="table" v-for="(i, j) of item" :key="i.id">
			{{i}}
		</div>
	</div>
	</div>
</div>
</template>
<script>
import axios from 'axios'
export default {
	data(){
		return{
			context : 'http://localhost:8080/',
			list : [],
			searchWord : ''
		}
	},
	methods : {
		find(){
		axios
		.get(`${this.context}/students/search/${this.searchWord}`)
		.then(res=>{
			this.list = res.data
			alert(`회원수 : ${res.data.length}`)
		})
		.catch(()=>{
			alert('axios실패')
		})
		},
		pratice(searchWord){
			this.searchWord = searchWord
			axios
			.get(`${this.context}/students/search/${searchWord}`)
			.then(res=>{
				this.list = res.data
				alert(`${res.data}`)
			})
			.catch(()=>{
				alert(`axios실패`)
			})
		}
	}
}
</script>
<style scoped>
 body {
    color: #999;
	background: #f5f5f5;
	font-family: 'Varela Round', sans-serif;
}
.form-control {
	box-shadow: none;
	border-color: #ddd;
}
.form-control:focus {
	border-color: #4aba70; 
}
.login-form {
    width: 350px;
	margin: 0 auto;
	padding: 30px 0;
}
.login-form form {
    color: #434343;
	border-radius: 1px;
    margin-bottom: 15px;
    background: #fff;
	border: 1px solid #f3f3f3;
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    padding: 30px;
}
.login-form h4 {
	text-align: center;
	font-size: 22px;
    margin-bottom: 20px;
}
.login-form .avatar {
    color: #fff;
	margin: 0 auto 30px;
    text-align: center;
	width: 100px;
	height: 100px;
	border-radius: 50%;
	z-index: 9;
	background: #4aba70;
	padding: 15px;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
}
.login-form .form-group {
    margin-bottom: 20px;
}
.login-form .form-control, .login-form .btn {
	min-height: 40px;
	border-radius: 2px; 
    transition: all 0.5s;
}
.login-form .close {
    position: absolute;
	top: 15px;
	right: 15px;
}
.login-form .btn {
	background: #4aba70;
	border: none;
	line-height: normal;
}
.login-form .btn:hover, .login-form .btn:focus {
	background: #42ae68;
}
.login-form .checkbox-inline {
    float: left;
}
.login-form input[type="checkbox"] {
    margin-top: 2px;
}
.login-form .forgot-link {
    float: right;
}
.login-form .small {
    font-size: 13px;
}
.login-form a {
    color: #4aba70;
}
.table{
	display : grid;
	grid-template-columns :  9% 9% 9% 9% 9% 9% 9% 9% 9% 9%;
}
.table{border : 1px solid black}
</style>