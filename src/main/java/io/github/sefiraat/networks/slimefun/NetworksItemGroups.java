package io.github.sefiraat.networks.slimefun;

import io.github.sefiraat.networks.Networks;
import io.github.sefiraat.networks.slimefun.groups.DummyItemGroup;
import io.github.sefiraat.networks.slimefun.groups.MainFlexGroup;
import io.github.sefiraat.networks.utils.Keys;
import io.github.sefiraat.networks.utils.Theme;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@UtilityClass
public final class NetworksItemGroups {

    public static final MainFlexGroup MAIN = new MainFlexGroup(
        Keys.newKey("main"),
        new SlimefunItemStack(
                "MAIN",
            new ItemStack(Material.BLACK_STAINED_GLASS),
            Theme.MAIN.getColor() + "Networks"
        ).item()
    );

    public static final DummyItemGroup MATERIALS = new DummyItemGroup(
        Keys.newKey("materials"),
        new SlimefunItemStack(
                "MATERIALS",
            new ItemStack(Material.WHITE_STAINED_GLASS),
            Theme.MAIN.getColor() + "Crafting Materials"
        ).item()
    );

    public static final DummyItemGroup TOOLS = new DummyItemGroup(
        Keys.newKey("tools"),
        new SlimefunItemStack(
                "TOOLS",
            new ItemStack(Material.PAINTING),
            Theme.MAIN.getColor() + "Network Management Tools"
        ).item()
    );

    public static final DummyItemGroup NETWORK_ITEMS = new DummyItemGroup(
        Keys.newKey("network_items"),
        new SlimefunItemStack(
                "NETWORK_ITEMS",
            new ItemStack(Material.BLACK_STAINED_GLASS),
            Theme.MAIN.getColor() + "Network Items"
        ).item()
    );

    public static final DummyItemGroup NETWORK_QUANTUMS = new DummyItemGroup(
        Keys.newKey("network_quantums"),
        new SlimefunItemStack(
                "NETWORK_QUANTUMS",
            new ItemStack(Material.WHITE_TERRACOTTA),
            Theme.MAIN.getColor() + "Network Quantum Storage Devices"
        ).item()
    );

    public static final ItemGroup DISABLED_ITEMS = new HiddenItemGroup(
        Keys.newKey("disabled_items"),
        new SlimefunItemStack(
                "DISABLED_ITEMS",
            new ItemStack(Material.BARRIER),
            Theme.MAIN.getColor() + "Disabled/Removed Items"
        ).item()
    );

    static {
        final Networks plugin = Networks.getInstance();

        // Slimefun Registry
        NetworksItemGroups.MAIN.register(plugin);
        NetworksItemGroups.MATERIALS.register(plugin);
        NetworksItemGroups.TOOLS.register(plugin);
        NetworksItemGroups.NETWORK_ITEMS.register(plugin);
        NetworksItemGroups.NETWORK_QUANTUMS.register(plugin);
        NetworksItemGroups.DISABLED_ITEMS.register(plugin);
    }

    public static class HiddenItemGroup extends ItemGroup {

        public HiddenItemGroup(NamespacedKey key, ItemStack item) {
            super(key, item);
        }

        @Override
        public boolean isHidden(@Nonnull Player p) {
            return true;
        }
    }
}
