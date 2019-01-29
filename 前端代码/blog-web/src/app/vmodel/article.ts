import { Channel } from './channel';
export class Article{
	id: number;
	isDel: number;
	abstracts: string;
	author: string;
	clickNum: number;
	content: string;
	createTime: string;
	description: string;
	isRecommend: string;
	isTop: string;
	keywords: string;
	lastModifiedDate: string;
	source: string;
	status: string;
	thumb: string;
	title: string;
	channel: Channel;
}