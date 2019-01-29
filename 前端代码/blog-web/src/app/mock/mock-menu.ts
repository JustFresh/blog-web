import { AdminMenu } from '../vmodel/admin-menu';
export const ADMIN_MENUS: AdminMenu[] = [
	{"id": 11,"menuName": "控制台","opt":"index","url":"/admin/index","icon":"dashboard","sort":1,"module":"index","children":[
		{"id": 111,"menuName": "控制台","opt":"index","url":"/admin/index","icon":"dashboard","sort":1,"module":"index","children":[]},
		{"id": 112,"menuName": "用户管理","opt":"user","url":"/admin/user/list","icon":"user","sort":2,"module":"index","children":[]},
		{"id": 113,"menuName": "操作员管理","opt":"admin","url":"/admin/admin/list","icon":"smile","sort":3,"module":"index","children":[]},
		{"id": 114,"menuName": "分类管理","opt":"channel","url":"/admin/channel/list","icon":"bars","sort":4,"module":"index","children":[]},
		{"id": 115,"menuName": "广告管理","opt":"adv","url":"/admin/adv/list","icon":"notification","sort":5,"module":"index","children":[]},
		{"id": 115,"menuName": "友情链接管理","opt":"links","url":"/admin/links/list","icon":"link","sort":6,"module":"index","children":[]}
	]},{"id": 21,"menuName": "文章","opt":"article","url":"/admin/article/list","icon":"file","sort":2,"module":"article","children":[
		{"id": 211,"menuName": "文章管理","opt":"article","url":"/admin/article/list","icon":"file","sort":1,"module":"article","children":[]},
		{"id": 212,"menuName": "评论管理","opt":"comment","url":"/admin/comment/list","icon":"message","sort":2,"module":"article","children":[]}
	]},{"id": 31,"menuName": "报表","opt":"chart","url":"/admin/chart/list","icon":"area-chart","sort":3,"module":"chart","children":[
		{"id": 311,"menuName": "报表统计","opt":"chart","url":"/admin/chart/list","icon":"area-chart","sort":1,"module":"chart","children":[]}
	]}
];