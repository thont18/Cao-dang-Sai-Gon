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
    name: 'Fish Types',
    url: '/fishTypes',
    icon: 'icon-drop'
  },
  {
    name: 'Fishs',
    url: '/fishs',
    icon: 'icon-drop'
  },

];
