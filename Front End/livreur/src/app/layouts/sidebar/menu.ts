import { MenuItem } from './menu.model';

export const MENU: MenuItem[] = [
    {
        id: 1,
        label: 'MENUITEMS.MENU.TEXT',
        isTitle: true
    },
    //=========================== Dashboard =========================

    {
        id: 2,
        label: 'MENUITEMS.DASHBOARDS.TEXT',
        link: '/dashboard',
    },
    {
        id: 7,
        isLayout: true
    },
    //=========================== Chat =========================

    {
        id: 8,
        label: 'MENUITEMS.APPS.TEXT',
        isTitle: true
    },
    {
        id: 10,
        label: 'MENUITEMS.CHAT.TEXT',
        icon: 'bx-chat',
        link: '/chat',

    },
    //=========================== Ecommerce =========================

    {
        id: 12,
        label: 'MENUITEMS.ECOMMERCE.TEXT',
        icon: 'bx-store',
        subItems: [

            {
                id: 15,
                label: 'MENUITEMS.ECOMMERCE.LIST.ORDERS',
                link: '/ecommerce/orders',
                parentId: 12
            },

        ]
    }
];

