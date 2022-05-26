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
                id: 14,
                label: 'MENUITEMS.ECOMMERCE.LIST.PRODUCTDETAIL',
                link: '/ecommerce/product-detail/1',
                parentId: 12
            },
            {
                id: 21,
                label: 'MENUITEMS.ECOMMERCE.LIST.AVIS',
                link: '/ecommerce/avis',
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
                id: 15,
                label: 'MENUITEMS.ECOMMERCE.LIST.ORDERS',
                link: '/ecommerce/orders',
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
        subItems: [
            {
                id: 37,
                label: 'MENUITEMS.INVOICES.LIST.INVOICELIST',
                link: '/invoices/list',
                parentId: 36
            },
            {
                id: 38,
                label: 'MENUITEMS.INVOICES.LIST.INVOICEDETAIL',
                link: '/invoices/detail',
                parentId: 36
            },
        ]
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
    },
    //=========================== AUTHENTICATION =========================

    {
        id: 56,
        label: 'MENUITEMS.PAGES.TEXT',
        isTitle: true
    },
    {
        id: 57,
        label: 'MENUITEMS.AUTHENTICATION.TEXT',
        icon: 'bx-user-circle',
        badge: {
            variant: 'success',
            text: 'MENUITEMS.AUTHENTICATION.BADGE',
        },
        subItems: [
            {
                id: 58,
                label: 'MENUITEMS.AUTHENTICATION.LIST.LOGIN',
                link: '/account/login',
                parentId: 57
            },

            {
                id: 60,
                label: 'MENUITEMS.AUTHENTICATION.LIST.REGISTER',
                link: '/account/signup',
                parentId: 57
            },

            {
                id: 62,
                label: 'MENUITEMS.AUTHENTICATION.LIST.RECOVERPWD',
                link: '/account/reset-password',
                parentId: 57
            },

            {
                id: 66,
                label: 'MENUITEMS.AUTHENTICATION.LIST.CONFIRMMAIL',
                link: '/pages/confirm-mail',
                parentId: 57
            },

            {
                id: 68,
                label: 'MENUITEMS.AUTHENTICATION.LIST.EMAILVERIFICATION',
                link: '/pages/email-verification',
                parentId: 57
            }
        ]
    },
    //=========================== Utility =========================

    {
        id: 72,
        label: 'MENUITEMS.UTILITY.TEXT',
        icon: 'bx-file',
        subItems: [
            {
                id: 74,
                label: 'MENUITEMS.UTILITY.LIST.MAINTENANCE',
                link: '/pages/maintenance',
                parentId: 72
            },
            {
                id: 74,
                label: 'Coming Soon',
                link: '/pages/coming-soon',
                parentId: 72
            },
            {
                id: 75,
                label: 'MENUITEMS.UTILITY.LIST.TIMELINE',
                link: '/pages/timeline',
                parentId: 72
            },
            {
                id: 76,
                label: 'MENUITEMS.UTILITY.LIST.FAQS',
                link: '/pages/faqs',
                parentId: 72
            },
            {
                id: 78,
                label: 'MENUITEMS.UTILITY.LIST.ERROR404',
                link: '/pages/404',
                parentId: 72
            },
            {
                id: 79,
                label: 'MENUITEMS.UTILITY.LIST.ERROR500',
                link: '/pages/500',
                parentId: 72
            },
        ]
    }
];

