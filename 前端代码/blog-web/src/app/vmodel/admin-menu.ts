export class AdminMenu{
	id: number;
	menuName: string;
	opt: string;
	url: string;
	icon: string;
	sort: number;
	module: string;
	children: AdminMenu[];
}