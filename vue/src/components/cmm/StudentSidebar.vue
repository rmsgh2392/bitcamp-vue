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
				{menu : '글쓰기',link :'#'},
				{menu : '글 목록',link :'#'},
				{menu : '글 수정',link :'#'},
				{menu : '글 삭제',link :'#'},
				{menu : '글 검색',link :'#'}
			]
		}
	}
}
</script>