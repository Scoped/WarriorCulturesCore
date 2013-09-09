package WarriorCulturesCore.Scoped.com.github.core.handler;

import WarriorCulturesCore.Scoped.com.github.core.helper.LocalizationHelper;
import WarriorCulturesCore.Scoped.com.github.lib.Localizations;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class LocalizationHandler
{
	public static void loadLanguages()
	{
		for(String LocationFile : Localizations.localFiles)
		{
			LanguageRegistry.instance().loadLocalization(LocationFile, LocalizationHelper.getLocalFromFileName(LocationFile), LocalizationHelper.isXMLFile(LocationFile));
		}
	}
}
