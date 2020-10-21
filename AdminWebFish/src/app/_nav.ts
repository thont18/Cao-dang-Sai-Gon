import { INavData } from '@coreui/angular';

export const navItems: INavData[] = [
  {
    name: 'Dashboard',
    url: '/dashboard',
    icon: 'icon-speedometer',
    badge: {
      variant: 'info',
      text: 'NEW'
    }
  },
  {
    title: true,
    name: 'Theme'
  },
  {
    name: 'Customers',
    url: '/customers',
    icon: 'icon-drop'
  },
  {
    name: 'Product Types',
    url: '/productTypes',
    icon: 'icon-drop'
  },
  {
    name: 'Products',
    url: '/products',
    icon: 'icon-drop'
  },
  {
    name: 'Service Types',
    url: '/serviceTypes',
    icon: 'icon-drop'
  },
  {
    name: 'Services',
    url: '/services',
    icon: 'icon-drop'
  }

];
