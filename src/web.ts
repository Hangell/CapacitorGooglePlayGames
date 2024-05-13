import { WebPlugin } from '@capacitor/core';

import type { CapacitorGooglePlayGamesPlugin } from './definitions';

export class CapacitorGooglePlayGamesWeb extends WebPlugin implements CapacitorGooglePlayGamesPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
