export class Select{
	key: string;
	value: string;
}

export const ADV_TYPES: Select[] = [
	{key:'1',value:'PC端'},
	{key:'2',value:'APP端'}
];

export const ADV_POSITIONS: Select[] = [
	{key:'1',value:'首页大轮播'},
	{key:'2',value:'微信公众号'},
	{key:'3',value:'腰带轮播'},
	{key:'4',value:'安卓APP下载'},
	{key:'5',value:'苹果APP下载'}
];

export const STATUS_LIST: Select[] = [
	{key:'0',value:'禁用'},
	{key:'1',value:'启用'}
];

export const IS_BLANK_LIST: Select[] = [
	{key:'0',value:'当前窗口'},
	{key:'1',value:'新窗口'}
];