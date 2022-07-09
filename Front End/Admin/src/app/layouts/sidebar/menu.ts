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
                id: 23,
                label: 'MENUITEMS.ECOMMERCE.LIST.CATEGORIES',
                link: '/ecommerce/categories',
                parentId: 12
            },
            {
                id: 20,
                label: 'MENUITEMS.ECOMMERCE.LIST.ADDPRODUCT',
                link: '/ecommerce/add-product',
                parentId: 12
            },
            {
                id: 13,
                label: 'MENUITEMS.ECOMMERCE.LIST.PRODUCTS',
                link: '/ecommerce/products',
                parentId: 12
            },
            {
                id: 14,
                label: 'MENUITEMS.ECOMMERCE.LIST.PRODUCTDETAIL',
                link: '/ecommerce/product-detail/1',
                parentId: 12
            },                       
            {
                id: 15,
                label: 'MENUITEMS.ECOMMERCE.LIST.ORDERS',
                link: '/ecommerce/orders',
                parentId: 12
            },
            {
                id: 21,
                label: 'MENUITEMS.ECOMMERCE.LIST.AVIS',
                link: '/ecommerce/avis',
                parentId: 12
            }
        ]
    },
    //=========================== Email =========================

    {
        id: 29,
        label: 'MENUITEMS.EMAIL.TEXT',
        icon: 'bx-envelope',
        link: '/email/inbox'
        
    },
    //=========================== Invoices =========================

    {
        id: 36,
        label: 'MENUITEMS.INVOICES.TEXT',
        icon: 'bx-receipt',
        link: '/invoices/list'
    },

    //=========================== Contact =========================

    {
        id: 48,
        label: 'MENUITEMS.CONTACTS.TEXT',
        icon: 'bxs-user-detail',
        subItems: [
            {
                id: 50,
                label: 'MENUITEMS.CONTACTS.LIST.USERLIST',
                link: '/contacts/list',
                parentId: 48
            },
            
            {
                id: 52,
                label: 'MENUITEMS.CONTACTS.LIST.LIVREUR',
                link: '/contacts/livreur',
                parentId: 48
            },
            {
                id: 53,
                label: 'MENUITEMS.CONTACTS.LIST.CLIENT',
                link: '/contacts/client',
                parentId: 48
            },{
                id: 51,
                label: 'MENUITEMS.CONTACTS.LIST.PROFILE',
                link: '/contacts/profile',
                parentId: 48
            }
        ]
    }

];

