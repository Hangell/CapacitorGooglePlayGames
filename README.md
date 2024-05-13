
# Capacitor Google Play Games Plugin

Este plugin permite a integração com o Google Play Games Services em aplicações Ionic usando Capacitor. Com este plugin, os desenvolvedores podem facilmente implementar funcionalidades de login e autenticação através do Google Play Games, acessar leaderboards, achievements e muito mais.

## Recursos
- Login e autenticação com Google Play Games Services.
- Verificação de autenticação do usuário.
- Facilita a implementação de funcionalidades sociais e de pontuação.

## Instalação

Para usar o plugin, siga estas etapas:

### Passo 1: Instalar o plugin

```bash
npm install capacitor-google-play-games
npx cap sync
```

### Passo 2: Configurar Android

1. **Adicionar a dependência do Google Play Games no Gradle**:
   Edite o arquivo `android/build.gradle` e adicione a seguinte dependência:

   ```gradle
   dependencies {
       implementation 'com.google.android.gms:play-services-games-v2:+'
   }
   ```

2. **Configurar o AndroidManifest.xml**:
   Adicione o seguinte meta-data dentro do elemento `<application>` no arquivo `android/src/main/AndroidManifest.xml`:

   ```xml
   <application>
       <meta-data android:name="com.google.android.gms.games.APP_ID"
                  android:value="@string/game_services_project_id"/>
   </application>
   ```

3. **Definir o ID do Projeto**:
   No arquivo `android/src/main/res/values/strings.xml`, defina o ID do seu projeto:

   ```xml
   <resources>
       <string name="game_services_project_id" translatable="false">SEU_ID_DO_PROJETO_AQUI</string>
   </resources>
   ```

### Passo 3: Usar o Plugin

Depois de instalar e configurar o plugin, você pode usá-lo em seu projeto Ionic da seguinte maneira:

## Exemplo de Uso

### Inicializar o SDK

Chame o método `initialize` quando sua aplicação iniciar:

```typescript
import { GooglePlayGames } from 'capacitor-google-play-games';

async function initializeGooglePlayGames() {
  await GooglePlayGames.initialize();
}
```

### Realizar Login

Para realizar o login do usuário:

```typescript
async function signIn() {
  try {
    const result = await GooglePlayGames.signIn();
    console.log('Login success:', result);
  } catch (error) {
    console.error('Login failed:', error);
  }
}
```

### Verificar Autenticação

Para verificar se o usuário está autenticado:

```typescript
async function checkAuthentication() {
  const authStatus = await GooglePlayGames.isAuthenticated();
  console.log('Is authenticated:', authStatus.isAuthenticated);
}
```

## Suporte

Para mais informações e suporte, visite [Capacitor Community](https://capacitorjs.com/community).
