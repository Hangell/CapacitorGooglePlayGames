export interface CapacitorGooglePlayGamesPlugin {
  signIn(): Promise<{ success: boolean; message?: string }>;
  isAuthenticated(): Promise<{ isAuthenticated: boolean }>;
}
