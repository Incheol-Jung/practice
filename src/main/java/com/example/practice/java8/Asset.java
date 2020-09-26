package com.example.practice.java8;

import java.util.List;
import java.util.function.Predicate;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Incheol Jung
 */
@Getter
@Setter
public class Asset {

    public enum AssetType {
        BOND,
        STOCK
    }

    private final AssetType type;
    private final int value;

    public Asset(AssetType type, int value) {
        this.type = type;
        this.value = value;
    }

    public static int totalAssetValues(final List<Asset> assets) {
        return assets.stream().mapToInt(Asset::getValue).sum();
    }

    public static int totalBondValues(final List<Asset> assets) {
        return assets.stream().mapToInt(asset -> asset.getType() == AssetType.BOND ? asset.getValue() : 0).sum();
    }

    public static int totalAssetValues2(final List<Asset> assets, final Predicate<Asset> assetPredicate) {
        return assets.stream().filter(assetPredicate).mapToInt(Asset::getValue).sum();
    }

    public void totalAssetValues3(final List<Asset> assets, final Predicate<Asset> assetPredicate) {
        totalAssetValues2(assets, asset -> asset.getType() == AssetType.BOND);
        totalAssetValues2(assets, asset -> asset.getType() == AssetType.STOCK);
    }

}
