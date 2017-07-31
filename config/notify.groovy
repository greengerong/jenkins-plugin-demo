for (item in Hudson.instance.items) {
    notification = item.properties.find {
        it.getKey().getClass() == com.tikal.hudson.plugins.notification.HudsonNotificationPropertyDescriptor
    }
    if (notification != null) {
        continue
    }

    println(">>>>>>>> Adding notification plugin to $item.name")
    protocol = com.tikal.hudson.plugins.notification.Protocol.UDP
    endpoint = new com.tikal.hudson.plugins.notification.Endpoint(protocol, '172.16.24.204:11337')
    notification = new com.tikal.hudson.plugins.notification.HudsonNotificationProperty([endpoint])

    item.addProperty(notification)
    item.save()
}