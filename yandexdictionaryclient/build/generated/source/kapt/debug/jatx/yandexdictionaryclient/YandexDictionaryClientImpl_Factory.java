// Generated by Dagger (https://dagger.dev).
package jatx.yandexdictionaryclient;

import dagger.internal.Factory;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class YandexDictionaryClientImpl_Factory implements Factory<YandexDictionaryClientImpl> {
  @Override
  public YandexDictionaryClientImpl get() {
    return newInstance();
  }

  public static YandexDictionaryClientImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static YandexDictionaryClientImpl newInstance() {
    return new YandexDictionaryClientImpl();
  }

  private static final class InstanceHolder {
    private static final YandexDictionaryClientImpl_Factory INSTANCE = new YandexDictionaryClientImpl_Factory();
  }
}