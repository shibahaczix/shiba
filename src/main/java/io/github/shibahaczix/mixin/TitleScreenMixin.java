package io.github.shibahaczix.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import io.github.shibahaczix.Shiba;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
	@Inject(method = "init", at = @At("TAIL"))
	public void shiba$onInit(CallbackInfo ci) {
		Shiba.INSTANCE.getLOGGER().info("This line is printed by an example mod mixin!");
	}
}
