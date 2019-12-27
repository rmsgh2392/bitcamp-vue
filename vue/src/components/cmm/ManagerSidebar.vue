<template>
<div>
<ul class="menu">
	<li v-for="i of sidebars" :key="i.menu" >
		<router-link :to="i.link">{{i.menu}}</router-link>
	</li>
</ul>
</div>  
</template>	
<script>
export default{
	data(){
		return {
			sidebars : [
				{menu : '학생정보목록',link :'/studentList'},
				{menu : '학생정보수정',link :'/studentEdit'},
				{menu : '학생정보삭제',link :'/studentRemove'},
				{menu : '학생정보검색',link :'/studentFindOne'},
				{menu : '조건별 학생검색',link : '/studentFindSome'}
			]
		}
	}
}
</script>
<style scoped>

</style>