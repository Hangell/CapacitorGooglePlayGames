import { registerPlugin } from '@capacitor/core';

import type { CapacitorGooglePlayGamesPlugin } from './definitions';

const CapacitorGooglePlayGames = registerPlugin<CapacitorGooglePlayGamesPlugin>('CapacitorGooglePlayGames', {
  web: () => import('./web').then(m => new m.CapacitorGooglePlayGamesWeb()),
});

export * from './definitions';
export { CapacitorGooglePlayGames };
