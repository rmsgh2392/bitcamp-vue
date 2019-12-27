<template>
<ul class="menu">
	<li v-for="i of sidebars" :key="i.menu" >
		<router-link :to="i.link">{{i.menu}}</router-link>
	</li>
</ul>  
</template>	
<script>
export default{
	data(){
		return {
			sidebars : [
				{menu : '글쓰기',link :'/articleAdd'},
				{menu : '목록',link :'/articles'},
				{menu : '글수정',link :'/articleEdit'},
				{menu : '삭제',link :'/articleRemove'},
				{menu : '검색',link :'/articleFindOne'}
			]
		}
	}
}
</script>