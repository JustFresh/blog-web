export class Channel{
	id: number;
	channelName: string;
	reorder: string;
	uri: string;
	icon: string;
	isBlank: string;
	children?: Channel[];
	createTime: string;
	status: string;
	description: string;
	level: number;
	expand: boolean;
}