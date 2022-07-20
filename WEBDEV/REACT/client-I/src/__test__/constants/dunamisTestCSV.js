export let nullJson = "{}"

export let iaasCSV1 = String.raw`IN_ABC,OUT_event.type,unknown
"success","success",`;
export let iaasCSV2 = String.raw`IN_DEF,"OUT_event.subtype"
"success","success"`;
export let iaasCSV3 = String.raw`IN_ABC,IN_DEF,IN_GHI,OUT_event.type,OUT_event.subtype,OUT_event.subcategory
success,failure,,,,
success,,,success,,
,success,,,success,
,,"hello-world",,,"hello-world"`;
export let iaasCSV4 = String.raw`IN_activityname,IN_type,IN_monitor,IN_oldkey1,IN_oldkey2,OUT_event.type,OUT_newkey1,OUT_newkey2
click,oldval2,oldval3,,,success,,newval2
,,,"hello","oldval2",,"success","$$1"
,(.*),,"(.*)","oldval2",,"$1","$1$$$2"`;
export let iaasCSV5 = String.raw`CONFIG,IN_a,IN_b,IN_c,IN_d,IN_e,OUT_p,OUT_q,OUT_r,OUT_s,OUT_t
,val_a,val_b,val_c,val_d,val_e,val_p,val_q,val_r,val_s,val_t
,val_w,val_x,,,,val_w,val_x,,,
,,,val_y,(.*),,,,val_y,$1,$1
,(.*)(abc)(.*),,,,,$1,$2,$3,,
missing-key-action=skip,(.*),(.*),,,,,$1-$2,,,
,(.*),,,,,$1,,,,`;
export let iaasCSV6 = String.raw`IN_FeatureTime,IN_Category,IN_SubCategory,IN_FeatureName,IN_PGuid,IN_MachineID,IN_SessionID,IN_OS,IN_OSVersion,IN_OSType,IN_OSLanguage,IN_UserLanguage,IN_Processor,IN_ProcessorName,IN_ProcessorModel,IN_NumProcessors,IN_Speed,IN_Memory,IN_MonitorCount,IN_TouchPoints,IN_TimeZoneOffset,IN_DefaultBrowser,IN_width,IN_height,IN_ExecutableName,IN_ExecutableVersion,IN_ExecutableBuild,IN_ExecutableLanguage,IN_ProductFamily,IN_ProductName,IN_ProductVersion,IN_ProductBuild,IN_ProductLanguage,IN_IsPrerelease,IN_User,IN_SessionStartTime,IN_LogType,IN_IdleTimeThreshold,IN_IdleTimeActiveBias,IN_time,IN_doc,IN_group,IN_seq,IN_id,OUT_event.dts,OUT_event.category,OUT_event.workflow,OUT_event.subcategory,OUT_event.subtype,OUT_event.user_guid,OUT_event.device_guid,OUT_event.session_guid,OUT_event.language,OUT_event.user_agent,OUT_event.build,OUT_source.name,OUT_source.version,OUT_source.os_version,OUT_source.device,OUT_source.platform
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,(.*),(.*),,,,,,,,,,,,,,,,,,,,,,,,,$1.$2,,,
(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,$1,,,,,,,,,,,,,,,
,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,$1,,,,,,,,,,,,,
,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,$1,,,,,,,,,,,,
,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,$1,,,,,,,,,,,
,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,$1,,,,,,,,,,
,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,$1,,,,,,,,,
,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,$1,,,,,,,,
,,,,,,,(.*),,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,$1$2
,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,$1,,
,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,$1,
,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,$1,,,,,,
,,,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,$1,,,,
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,$1,,,,,,,
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,"""True""",,,,,,,,,,,,,,,,,,,,,prerelease,,,,,
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,,
,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,(.*),,,,,,,,,,,,,,,,`;
export let iaasCSV7 = String.raw`CONFIG,IN_IsPrerelease,OUT_event.dts,OUT_event.workflow,OUT_event.subcategory,OUT_event.subtype,OUT_event.build,OUT_source.version,OUT_source.platform,OUT_event.user_guid,OUT_event.device_guid,OUT_event.session_guid,OUT_source.os_version,OUT_source.device,OUT_event.user_agent,OUT_source.name,OUT_event.language,OUT_hb.params,OUT_hb.type,OUT_hb.table
non-standard-keys=include,,,,,,,,,,,,,,,,,$0,,
,,$+{FeatureTime},$+{Category},$+{SubCategory},$+{FeatureName},,$+{ProductVersion}.$+{ProductBuild},$+{OS}$+{OSType},$+{PGuid},$+{MachineID},$+{SessionID},$+{OSVersion},$+{ProcessorModel},$+{DefaultBrowser},$+{ProductName},$+{ProductLanguage},,,
case-sensitive-values=false,TRUE,,,,,prerelease,,,,,,,,,,,,,
non-standard-keys=exclude,,,,,,,,,,,,,,,,,,,`;
export let iaasCSV8 = String.raw`CONFIG,IN_doc,IN_seq,IN_Category,IN_SubCategory,IN_FeatureName,IN_FeatureTime,OUT_event.workflow,OUT_event.subcategory,OUT_event.subtype,OUT_event.dts
,(.*),40,,,,,,$+{SubCategory},,$+{FeatureTime}
,,,(.*),,,,$1,,,
,,,,(.*),,,,$1,,`;
export let iaasCSV9 = String.raw`CONFIG,IN_doc,IN_seq,IN_Category,IN_SubCategory,IN_FeatureName,IN_FeatureTime,OUT_event.workflow,OUT_event.subcategory,OUT_event.subtype,OUT_event.dts,OUT_hb.params
missing-key-value=unknown,(?<doc>.*),(.*),(.*),(.*),,,$3-$+{doc},$4,,,
non-standard-keys=include,,,,,,,,,,,$0
non-standard-keys=exclude,,,,,,,,,,,`;
export let iaasCSV10 = String.raw`CONFIG,OUT_event.workflow,"OUT_event.subcategory",OUT_event.subtype,OUT_event.dts,IN_Category,IN_SubCategory,IN_FeatureTime
search-replace-substrings=true,,,,,/[\\[\\]\\(\\)]/*/g,,/\\s*(\\S(.*\\S)?)\\s*/$1/
,"$+{Category}",\L$+{SubCategory}-\U$+{FeatureName},$+{FeatureName},,,,
,,,,$+{FeatureTime},,,
non-standard-keys=exclude,,,,,,,`;
export let iaasCSV11 = String.raw`CONFIG,IN_Category,IN_SubCategory,OUT_event.workflow,OUT_event.subcategory,OUT_event.subtype,OUT_event.dts
,menu,,DESIGN,,,
,(.*),,\U$1,,,
,,,,\L$+{SubCategory}-\U$+{FeatureName},$+{FeatureName},$+{FeatureTime}
non-standard-keys=exclude,,,,,,`;


